class Solution {
    public int longestConsecutive(int[] nums) {
        // use a hashset
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        // iterate through nums, check for beginning of sequence
        // if beginning, go through entire sequence in set and count length
        // continue for all sequences and return longest length
        int longest = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int length = 1;  
                while (set.contains(num+length)) {
                    length++;
                }
                if (longest < length) {
                    longest = length;
                }
            }
        }

        return longest;
    }
}
