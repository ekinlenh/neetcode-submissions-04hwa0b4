class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(current, 0);
        return list;
    }

    public void backtrack(List<Integer> current, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        // choose option
        current.add(nums[index]);
        backtrack(current, index + 1);

        // undo
        current.remove(current.size() - 1);
        backtrack(current, index + 1);
    }
}
