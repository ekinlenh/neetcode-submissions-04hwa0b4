class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // DFS solution is too slow because we explore all paths. O(n!)
        // we can try using BFS, since the first time we reach the endWord
        // using BFS means that is the shortest path already.
        HashSet<String> set = new HashSet<>(); // mark visited strings
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                
                if (currWord.equals(endWord)) {
                    return length;
                }

                for (String w: wordList) {
                    if (canTransform(currWord, w) && !set.contains(w)) {
                        set.add(w);
                        queue.offer(w);
                    }
                }
            }

            length++;
        }

        return 0;
    }

    private boolean canTransform(String beginWord, String endWord) {
        // exactly one position has a different character

        int positions = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) {
                positions++;
            }
        }

        return positions == 1;
    }
}
