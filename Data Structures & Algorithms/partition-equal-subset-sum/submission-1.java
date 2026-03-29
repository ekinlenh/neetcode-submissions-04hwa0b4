class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];

        return dfs(nums, memo, sum / 2, 0, 0);
    }

    private boolean dfs(int[] nums, Boolean[][] memo, int sum, int curSum, int index) {
        if (curSum == sum) {
            return true;
        }

        if (curSum > sum || index >= nums.length) {
            return false;
        }

        if (memo[index][curSum] != null) {
            return memo[index][curSum];
        }

        memo[index][curSum] = dfs(nums, memo, sum, curSum + nums[index], index + 1)
                            || dfs(nums, memo, sum, curSum, index + 1);

        return memo[index][curSum];

    }
}
