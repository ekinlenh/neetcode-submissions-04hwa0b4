class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we can use a varying sliding window approach
        // to avoid duplicates, use a hashset and record if curr_index in set
        // initialize maxLength var
        // initalize with a left pointer, loop through string with a right pointer
        // add right pointer (char) to set
        // while the window contains a duplicate, update maxLength and 
        // remove left pointer and move left pointer forward
        // return maxLength

        int left = 0;
        Set<Character> chars = new HashSet<>();
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {            
            while (chars.contains(s.charAt(right))) {
                chars.remove(s.charAt(left));
                left++;
            } 

            chars.add(s.charAt(right));
            maxLength = Math.max(chars.size(), maxLength);
        }

        return maxLength;
    }
}
