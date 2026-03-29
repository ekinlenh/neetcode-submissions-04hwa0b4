class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (map.containsKey(i)) {
            return map.get(i);
        }

        int res = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
        map.put(i, res);
        return res;
    }
}
