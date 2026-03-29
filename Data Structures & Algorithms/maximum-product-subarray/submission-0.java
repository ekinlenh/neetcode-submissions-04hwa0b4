class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int maxProduct = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                // sub array
                int[] sub = Arrays.copyOfRange(nums, i, j + 1);
                int total = sub[0];
                for (int k = 1; k < sub.length; k++) {
                    total *= sub[k];
                }
                System.out.println(total);
                maxProduct = Math.max(maxProduct, total);
            }

            res = Math.max(res, maxProduct);
        }

        return res;
    }
}
