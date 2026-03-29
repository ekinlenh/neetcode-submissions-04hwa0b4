class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return recurse(s, wordDict, memo, 0);
        // ex: neetcode
        // find a word that you can break apart in string s
        // then we can recurse on the non-word part
        // neet --> recurse(code)
        // how can we find a word in the string?
        // start from an index, increment ending index until found word
        // base case: string is empty string, which means we can return true
    }

    private boolean recurse(String s, List<String> wordDict, Boolean[] memo, int index) {
        if (index >= s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (wordDict.contains(sub) && recurse(s, wordDict, memo, i)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }
}
