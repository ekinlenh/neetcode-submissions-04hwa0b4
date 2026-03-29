class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) { // treasure chest found
                    queue.offer(new int[] {i, j});
                }
            }
        }

        bfs(grid, queue);
    }

    private void bfs(int[][] grid, Queue<int[]> queue) {

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d: directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                    if (grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }

        }
    }
}
