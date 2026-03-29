class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    if (!visited[row][col]) {
                        res++;
                        dfs(grid, visited, row, col, n, m);
                    }
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c, int maxRow, int maxCol) {
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {r, c});
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int row = cell[0], col = cell[1];

            visited[row][col] = true;

            // up
            if (row - 1 >= 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
                stack.push(new int[] {row - 1, col});
            }

            // down
            if (row + 1 < maxRow && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
                stack.push(new int[] {row + 1, col});
            }

            // left
            if (col - 1 >= 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
                stack.push(new int[] {row, col - 1});
            }

            // right
            if (col + 1 < maxCol && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
                stack.push(new int[] {row, col + 1});
            }

            
        }
    }
}
