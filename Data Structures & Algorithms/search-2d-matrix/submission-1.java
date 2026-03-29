class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // we want to traverse the first row of the matrix
        // using binary search to see if target is found in that row
        // if not, we go to next row and repeat the process
        // repeat until we find target number

        for (int row = 0; row < matrix.length; row++) {
            int left = 0;
            int right = matrix[row].length - 1;
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
        }

        return false;
    }
}
