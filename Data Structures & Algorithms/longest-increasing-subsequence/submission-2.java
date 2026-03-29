class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        int maxLIS = 1;
        for (int i = 0; i < nums.length; i++) {
            maxLIS = Math.max(maxLIS, dfs(nums, memo, i));
        }

        return maxLIS;
    }

    private int dfs(int[] nums, int[] memo, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }

        int LIS = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                LIS = Math.max(LIS, 1 + dfs(nums, memo, i));
            }
        }

        memo[index] = LIS;
        return LIS;
    }              
}
