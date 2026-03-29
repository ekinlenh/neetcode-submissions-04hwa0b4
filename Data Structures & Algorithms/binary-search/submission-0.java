class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, target, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int target, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, target, end);
        }

        if (nums[middle] > target) {
            return binarySearch(nums, start, target, middle - 1);
        }

        return -1;
    }
}
