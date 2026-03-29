class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num: nums) {
            // three decisions:
            // start a new subarray at nums[index]
            // continue max product from nums[index - 1]
            // but also need to consider min values (because of negatives)

            int temp = curMax * num;
            curMax = Math.max(Math.max(temp, num * curMin), num);
            curMin = Math.min(Math.min(temp, num * curMin), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
