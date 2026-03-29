class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // loop through array, build a stack until reaching a warmer temperature
        // record warmer temperature for arr[i], and repeat for (j = i + 1) days
        // where j < i days
        // last element in array will always be 0
        // time complexity? since j <= i, O(n)??

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            Stack<Integer> futureDays = new Stack<>();
            int temperature = temperatures[i];
            res[i] = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                futureDays.push(temperatures[j]);
                if (temperature < temperatures[j]) {
                    res[i] = futureDays.size();
                    break;
                }
            }
        }

        res[temperatures.length - 1] = 0;

        return res;
    }
}
