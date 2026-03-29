class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int newValue = map.get(nums[i]) + 1;
                map.put(nums[i], newValue);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key: map.keySet()) {
            if (map.get(key) != 1) {
                return true;
            }
        }

        return false;
    }
}
