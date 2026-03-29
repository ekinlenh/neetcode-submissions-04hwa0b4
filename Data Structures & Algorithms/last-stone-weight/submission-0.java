class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // max heap 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int weight: stones) {
            maxHeap.offer(weight);
        }

        while (maxHeap.size() > 1) {
            int weightX = maxHeap.poll();
            int weightY = maxHeap.poll();

            if (weightX != weightY) {
                int newWeight = weightX - weightY;
                maxHeap.offer(newWeight);

            }

        }

        if (maxHeap.size() > 0) {
            return maxHeap.poll();
        } else {
            return 0;
        }
    }
}
