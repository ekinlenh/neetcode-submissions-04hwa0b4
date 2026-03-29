class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return dfs(nums, 0, Integer.MIN_VALUE);
    }

    private int dfs(int[] nums, int index, int prev) {
        if (index >= nums.length) {
            return 0;
        }

        // option 1: take the current value if valid
        int take = 0;
        if (nums[index] > prev) {
            take = 1 + dfs(nums, index + 1, nums[index]);
        }

        // option 2: don't take the current value b/c there are other valid choices
        int notTake = dfs(nums, index + 1, prev);

        return Math.max(take, notTake);
    }              
}
