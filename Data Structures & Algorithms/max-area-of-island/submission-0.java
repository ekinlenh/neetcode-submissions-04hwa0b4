class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int res = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    res = Math.max(res, dfs(grid, visited, row, col));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= visited.length
            || col < 0 || col >= visited[0].length
            || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int area = 1;

        // up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            area += dfs(grid, visited, row - 1, col);
        }

        // down
        if (row + 1 < visited.length && grid[row + 1][col] == 1) {
            area += dfs(grid, visited, row + 1, col);
        }

        // left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            area += dfs(grid, visited, row, col - 1);
        }

        // right
        if (col + 1 < visited[0].length && grid[row][col + 1] == 1) {
            area += dfs(grid, visited, row, col + 1);
        }

        return area;
    }
}
