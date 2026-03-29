class Solution {
    public boolean isPalindrome(String s) {
        // remove all non-alphanumeric characters in the string
        String regex = "[^a-zA-Z0-9]";
        String str = s.replaceAll(regex, "").toLowerCase();

        // we can use a two-pointers approach 
        // if the left and right pointers match, move closer, else return false
        // once pointers meet/cross, str is a palindrome
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
