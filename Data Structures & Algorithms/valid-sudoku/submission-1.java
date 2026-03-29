class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // checks validity of each row of the board
        for (int row = 0; row < board.length; row++) {
        HashMap<Character, Integer> map = new HashMap<>();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                        continue;
                }
                map.put(board[row][col], map.getOrDefault(board[row][col], 0) + 1);
                if (map.get(board[row][col]) > 1) {
                    return false;
                }
            }
        }

        // checks validity of each col of the board
        for (int col = 0; col < board.length; col++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int row = 0; row < board[col].length; row++) {
                if (board[row][col] == '.') {
                        continue;
                }
                map.put(board[row][col], map.getOrDefault(board[row][col], 0) + 1);
                if (map.get(board[row][col]) > 1) {
                    return false;
                }
            }
        }


        // checks validity of sub-boxes of the board
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }

        return true; 
    }
}
