class Solution {

    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(current, 0, target);
        return list;
    }

    public void backtrack(List<Integer> current, int index, int target) {
        // condition: must sum to target 
        // base case
        if (target == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == nums.length) {
            return;
        }

        // choose option
        current.add(nums[index]);
        backtrack(current, index, target - nums[index]);

        // undo option
        current.remove(current.size() - 1);
        backtrack(current, index + 1, target);
    }
}
