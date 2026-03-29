class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<>(), nums, target, 0);
        return res;
    }

    private void backtrack(List<Integer> list, int[] nums, int target, int index) {
        if (index >= nums.length || target < 0) {
            return;
        }

        if (target == 0 && !res.contains(list)) {
            res.add(new ArrayList<>(list));
        }

        list.add(nums[index]);
        backtrack(list, nums, target - nums[index], index);

        list.remove(list.size() - 1);
        backtrack(list, nums, target, index + 1);
    }
}
