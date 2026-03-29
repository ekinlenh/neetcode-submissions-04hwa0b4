class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums, memo, 0, -1);
    }

    private int dfs(int[] nums, int[][] memo, int index, int prevIndex) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index][prevIndex + 1] != -1) {
            return memo[index][prevIndex + 1];
        }

        // option 1: take the current value if valid
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + dfs(nums, memo, index + 1, index);
        }

        // option 2: don't take the current value b/c there are other valid choices
        int notTake = dfs(nums, memo, index + 1, prevIndex);

        memo[index][prevIndex + 1] = Math.max(take, notTake);
        return memo[index][prevIndex + 1];
    }              
}
