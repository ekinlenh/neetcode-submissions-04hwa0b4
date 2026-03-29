class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // ex: neetcode
        // find a word that you can break apart in string s
        // then we can recurse on the non-word part
        // neet --> recurse(code)
        // how can we find a word in the string?
        // start from an index, increment ending index until found word
        // base case: string is empty string, which means we can return true

        HashSet<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // dp[i] = true if s[0:i] is a valid word
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (wordSet.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
