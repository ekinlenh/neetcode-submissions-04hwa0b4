class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {        
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<Integer> list, int[] nums, boolean[] picked) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                picked[i] = true;
                list.add(nums[i]);
                backtrack(list, nums, picked);

                list.remove(list.size() - 1);
                picked[i] = false;
            }

        }
    }
}
