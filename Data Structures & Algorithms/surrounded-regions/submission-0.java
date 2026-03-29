class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // check border's
        // right and left borders
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
            if (board[row][COLS - 1] == 'O') {
                dfs(board, row, COLS - 1);
            }
        }

        // top and bottom borders
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
            if (board[ROWS - 1][col] == 'O') {
                dfs(board, ROWS - 1, col);
            }
        }

        // traverse matrix
        // transform all '0' to 'X'
        // transform all '#' to '0'
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                else if (board[row][col] == '#') board[row][col] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0,-1} };

        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});
        board[row][col] = '#';

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                    stack.push(new int[] {nr, nc});
                    board[nr][nc] = '#';
                }
            }
        }
    }
}
