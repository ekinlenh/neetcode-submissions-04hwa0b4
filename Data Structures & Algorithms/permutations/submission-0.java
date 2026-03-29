class Solution {

    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<Integer> curr = new ArrayList<>();
        backtrack(curr);
        return list;
    }

    public void backtrack(List<Integer> curr) {
        if (curr.size() == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {
            if (curr.contains(num)) {
                continue;
            }

            curr.add(num);
            backtrack(curr);
            curr.remove(curr.size() - 1);
        }
    }
}
