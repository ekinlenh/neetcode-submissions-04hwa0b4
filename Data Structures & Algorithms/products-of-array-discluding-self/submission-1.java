class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        HashMap<Integer, Integer> countZeros = new HashMap<>();

        int totalProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // account for edge case of array with zeroes
            if (nums[i] != 0) {
                totalProduct *= nums[i];
            } else {
                countZeros.put(0, countZeros.getOrDefault(0, 0) + 1);
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                if (countZeros.get(0) > 1) {
                    productArray[index] = 0;
                } else {
                    productArray[index] = totalProduct;
                }
            } else if (containsZero(nums)){
                productArray[index] = 0;
            } else {
                productArray[index] = totalProduct / nums[index];
            }
        }

        return productArray;

    }

    public boolean containsZero(int[] nums) {
        for (int n: nums) {
            if (n == 0) {
                return true;
            }
        }

        return false;
    }
}  
