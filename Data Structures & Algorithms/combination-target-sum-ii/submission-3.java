class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<Integer> list, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }

        // choose element
        list.add(candidates[index]);
        backtrack(list, candidates, target - candidates[index], index + 1);

        // don't choose element
        list.remove(list.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        backtrack(list, candidates, target, index + 1);

    }
}