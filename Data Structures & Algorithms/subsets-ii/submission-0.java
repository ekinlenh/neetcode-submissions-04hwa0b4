class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            // check if res contains subset already
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(nums[index]);
        backtrack(list, nums, index + 1);

        list.remove(list.size() - 1);
        backtrack(list, nums, index + 1);
    }
}
