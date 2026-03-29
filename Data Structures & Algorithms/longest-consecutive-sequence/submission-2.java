class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num: nums) {
            int length = 1;
            while (set.contains(num + 1)) {
                length++;
                num++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
