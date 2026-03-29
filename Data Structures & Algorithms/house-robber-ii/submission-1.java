class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // case 1: start from first house to (last - 1) house
        // case 2: start from second house to last house
        // return max of the two 
        int[] case1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] case2 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(dfs(case1), dfs(case2));

    }

    private int dfs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];

    }
}
