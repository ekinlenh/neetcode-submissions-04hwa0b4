class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // condition: 
        // touching Pacific = first row or first column
        // touching Atlantic = last row or last column
        // spread out from cell we check
        // maybe use dfs to expand and check if heihg is equal or lower to current cell
        // then add those cells to the list
        // keep track of two boolean conditions, if both are true, add to list    

        List<List<Integer>> list = new ArrayList<>();

        int ROWS = heights.length;
        int COLS = heights[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boolean[][] visited = new boolean[ROWS][COLS];

                if (dfs(heights, visited, row, col)) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(row);
                    cell.add(col);
                    list.add(cell);
                }
            }
        }

        return list;
    }

    private boolean dfs(int[][] heights, boolean[][] visited, int row, int col) {

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        boolean pacific = false, atlantic = false;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];

            visited[r][c] = true;

            if (r == 0 || c == 0) pacific = true;
            if (r == heights.length - 1 || c == heights[0].length - 1) atlantic = true;

            if (pacific && atlantic) break;

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                int curHeight = heights[r][c];
                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length) {
                    if (heights[nr][nc] <= curHeight && !visited[nr][nc]) {
                        stack.push(new int[] {nr, nc});
                    }
                }
            }
        }

        return pacific && atlantic;
    }
}
