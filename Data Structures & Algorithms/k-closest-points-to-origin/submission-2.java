class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] res = new int[k][2];

        // min heap b/c we want to find closest distances
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(points[a[0]]), distance(points[b[0]]))
        );
            
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(new int[] {i});
        }

        // pull from minHeap and grab indices from points from hashmap
        for (int i = 0; i < k; i++) {
            int index = minHeap.poll()[0];

            res[i] = points[index];
        }

        return res;

    }

    private double distance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

}
