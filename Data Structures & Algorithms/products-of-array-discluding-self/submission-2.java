class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        int countZeros = 0;

        int totalProduct = 1;
        for (int num: nums) {
            // account for edge case of array with zeroes
            if (num == 0) {
                countZeros++;
            } else {
                totalProduct *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZeros > 1) {
                productArray[i] = 0;
            } else if (countZeros == 1) {
                productArray[i] = nums[i] == 0 ? totalProduct : 0;
            } else {
                productArray[i] = totalProduct / nums[i];
            }
        }

        return productArray;

    }
}  
