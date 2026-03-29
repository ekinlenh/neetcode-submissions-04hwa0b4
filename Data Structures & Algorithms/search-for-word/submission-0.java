class Solution {

    HashSet<Pair<Integer, Integer>> set = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int row, int col) {
        // explore all paths (up, down, left, right) for next character
        // continue exploring until no characters match the next one 
        // if word is not completed, backtrack back and explore all other possibilities
        if (wordIndex == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || 
            col < 0 || col >= board[row].length ||
            board[row][col] != word.charAt(wordIndex) ||
            set.contains(new Pair<>(row,col))) {
            return false;
        }

        set.add(new Pair<>(row, col));
        boolean res = dfs(board, word, wordIndex + 1, row - 1, col) ||
                    dfs(board, word, wordIndex + 1, row + 1, col) ||
                    dfs(board, word, wordIndex + 1, row, col - 1) ||
                    dfs(board, word, wordIndex + 1, row, col + 1);

        set.remove(new Pair<>(row, col));
        return res;
    }
}
