class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // we can use binary search to find the row in which the target will be in 
        // and then use binary search again to find the target within the row
        // Time Complexity: O(log(m*n))
        // Space Complexity: O(1)
        int ROWS = matrix.length, COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }

        int row = (top + bot) / 2;
        int left = 0;
        int right = COLS - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (matrix[row][middle] > target) {
                right = middle - 1;
            } else if (matrix[row][middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
