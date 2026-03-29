class Solution {
    public int maxArea(int[] heights) {
        // left pointer at the beginning
        // right pointer at the end
        // area = 0
        // take the current_area between left & right
        // if current_area > area --> area = current_area
        // return area;

        int area = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int length = 0, width = right - left;
            if (heights[left] < heights[right]) {
                length = heights[left];
            } else {
                length = heights[right];
            }

            int currentArea = length * width;
            if (currentArea > area) {
                area = currentArea;
            }

            // TODO: fix logic here
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}
