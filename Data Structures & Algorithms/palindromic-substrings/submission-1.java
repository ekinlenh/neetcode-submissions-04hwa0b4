class Solution {                                                                                                                   
    public int countSubstrings(String s) {
        return countSubstringsHelper(s, 0);
    }

    private int countSubstringsHelper(String s, int start) {
        if (start >= s.length()) {
            return 0;
        }

        int count = 0;

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                count++;
            }
        }

        return count + countSubstringsHelper(s, start + 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }

        return true;
    }
}                                                                                                                    