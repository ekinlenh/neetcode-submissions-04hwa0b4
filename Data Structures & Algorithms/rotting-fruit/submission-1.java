class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int totalFresh = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                } else if (grid[row][col] == 1) {
                    totalFresh++;
                }
            }
        }

        return bfs(grid, queue, 0, totalFresh);
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int minutes, int totalFresh) {

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                    if (grid[nr][nc] == 1) {
                        totalFresh--;
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[] {nr, nc});

                        minutes = Math.max(minutes, grid[nr][nc] - 2);
                    }
                }
            }
        }

        return (totalFresh == 0) ? minutes : -1;
    }
}
