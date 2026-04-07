class Solution {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // bit-wise operator ^
            // identical numbers are XORed
            result = result ^ nums[i];
        }

        return result;

    }
}
