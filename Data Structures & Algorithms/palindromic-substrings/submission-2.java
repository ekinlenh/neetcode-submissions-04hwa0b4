class Solution {                                                                                                                   
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            count += countPalindrome(s, i, i);

            // even length palindromes
            count += countPalindrome(s, i, i+1);
        }

        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }
}                                                                                                                    