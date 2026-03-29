class Solution {
    public int findMin(int[] nums) {
        
        int minimum = nums[0];

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // this means array is already sorted
            if (nums[left] <= nums[right]) {
                minimum = Math.min(minimum, nums[left]);
                break;
            }

            int middle = left + ((right - left) / 2);
            minimum = Math.min(nums[middle], minimum);

            if (nums[left] <= nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return minimum;
    }
}
