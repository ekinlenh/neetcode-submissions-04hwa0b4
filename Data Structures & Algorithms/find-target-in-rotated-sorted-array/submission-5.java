class Solution {
    public int search(int[] nums, int target) {
        
        // we want to check nums[middle]
        // if nums[middle] > target, we want to check to the right of nums[middle]
        // else check to the left of nums[middle]

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[left] <= nums[middle]) {
                if (target > nums[middle] || target < nums[left]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }
}

