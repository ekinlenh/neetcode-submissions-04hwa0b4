class Node {

    Node[] children = new Node[26];
    boolean word = false;
}

class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new Node();
            }
            curr = curr.children[i];
        }

        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, Node root) {
        Node curr = root;

        for (int index = j; index < word.length(); index++) {
            char c = word.charAt(index);
            if (c == '.') {
                for (Node child: curr.children) {
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }

                return false;
            } else {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    return false;
                }
                curr = curr.children[i];
            }
        }

        return curr.word;
    }
}
