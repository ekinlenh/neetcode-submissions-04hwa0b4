class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {  
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // dfs from pacific
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, COLS - 1);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, ROWS - 1, c);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    list.add(cell);
                }
            }
        }

        return list;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];

            visited[r][c] = true;

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                int curHeight = heights[r][c];
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                    if (heights[nr][nc] >= curHeight && !visited[nr][nc]) {
                        stack.push(new int[] {nr, nc});
                    }
                }
            }
        }

    }
}
