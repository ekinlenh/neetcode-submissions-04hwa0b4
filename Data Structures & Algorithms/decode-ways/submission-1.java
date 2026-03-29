class Solution {

    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        
        return dfs(s, memo, 0);
    }

    private int dfs(String s, int[] memo, int i) {
        if (i >= s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int ways = dfs(s, memo, i + 1);

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                ways += dfs(s, memo, i + 2);
            }
        }

        return ways;
    }
}
