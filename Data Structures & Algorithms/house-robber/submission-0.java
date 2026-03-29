class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        int res = 0;
        return robHelper(nums, 0, 0);
    }

    private int robHelper(int[] nums, int res, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }

        res = Math.max(nums[index] + robHelper(nums, res, index + 2), robHelper(nums, res, index + 1));
        map.put(index, res);

        return res;
    }
}
