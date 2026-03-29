class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] res = new int[k][2];

        // min heap b/c we want to find closest distances
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        HashMap<Integer, Double> map = new HashMap<>();
            
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            double distance = (Math.sqrt((x * x) + (y * y)));
            minHeap.offer(distance);
            map.put(i, distance);
        }

        // pull from minHeap and grab indices from points from hashmap
        int index = 0;
        for (int i = 0; i < k; i++) {
            double distance = minHeap.poll();
            int key = getKeyFromValue(map, distance);

            System.out.println(index + " " + distance);
            if (index != -101) {
                res[index][0] = points[key][0];
                res[index][1] = points[key][1];
                index++;
            }

        }

        return res;

    }

    private int getKeyFromValue(Map<Integer, Double> map, double value) {
        for (Map.Entry<Integer, Double> entry: map.entrySet()) {
            if (value == entry.getValue()) {
                int index = entry.getKey();
                map.remove(index);
                return index;
            }
        }

        return -101;
    }
}
