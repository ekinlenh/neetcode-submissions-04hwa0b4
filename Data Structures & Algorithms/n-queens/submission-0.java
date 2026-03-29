class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '.';
            }
        }

        backtrack(new ArrayList<>(), board, n, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<String> list, char[][] board, int n, int row, List<Integer> colPlacements) {
        if (row >= n) {
            List<String> copy = new ArrayList<>();
            for (char[] r: board) {
                copy.add(new String(r));
            }
            res.add(copy);
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            colPlacements.add(col);
            if (isValid(colPlacements)) {
                backtrack(list, board, n, row + 1, colPlacements);
            }
            board[row][col] = '.';
            colPlacements.remove(colPlacements.size() - 1);
        }
    }

    // checks if queen is in a valid position
    private boolean isValid(List<Integer> colPlacements) {
        int row = colPlacements.size() - 1;
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(row));
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }

        return true;
    }
}
