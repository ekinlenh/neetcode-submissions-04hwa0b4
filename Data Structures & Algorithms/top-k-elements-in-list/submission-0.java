class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        int[] freqArray = new int[k];
        List<Integer> sortedNums = new ArrayList<>(freqMap.keySet());
        sortedNums.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        for (int i = 0; i < k; i++) {
            freqArray[i] = sortedNums.get(i);
        }
        
        return freqArray;
    }
}
