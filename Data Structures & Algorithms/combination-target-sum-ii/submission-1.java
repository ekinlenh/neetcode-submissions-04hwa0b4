class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, sum, target, 0);
        return list;
    }

    public void backtrack(int[] candidates, List<Integer> sum, int target, int index) {
        if (target == 0) {
            List<Integer> curr = new ArrayList<>(sum);
            if (!list.contains(curr)) {
                list.add(curr);
            }
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // choose
        sum.add(candidates[index]);
        backtrack(candidates, sum, target - candidates[index], index + 1);

        // don't choose
        sum.remove(sum.size() - 1);
        backtrack(candidates, sum, target, index + 1);
    }
}
