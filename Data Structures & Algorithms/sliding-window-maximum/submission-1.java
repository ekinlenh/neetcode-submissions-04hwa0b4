class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // fixed sliding window approach
        // must determine size of output array (depends on k)
        // nums.length = 7 --> k = 3 --> output.length = 5
        // nums.length = 7 --> k = 5 --> output.length = 3
        // idea: (nums.length - k) + 1 = output.length
        // test: nums = [1, 2, 3, 4], k = 3; expected: output.length = 2
        // true
        // test: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 4; expected: output.length = 7
        // true

        int[] output = new int[(nums.length - k) + 1];

        // within each subarray, find max value (Arrays.copyOfRange() then loop)
        // get first subarray:
        int[] subArr = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(subArr);
        output[0] = subArr[subArr.length - 1];

        // loop through rest of the subarrays
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            subArr = Arrays.copyOfRange(nums, i - k + 1, i + 1);
            Arrays.sort(subArr);
            output[index] = subArr[subArr.length - 1];
            index++;
        }

        return output;
    }
}
