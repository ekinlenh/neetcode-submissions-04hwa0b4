class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i >= s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        int ways = dfs(s, i + 1);

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                ways += dfs(s, i + 2);
            }
        }

        return ways;
    }
}
