class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // lower bound: 1
        // upper bound: max(piles)
        int left = 1;
        int right = 0;
        for (int pile: piles) {
            right = Math.max(pile, right);
        }

        int min = right;
        while (left <= right) {
            int speed = (right + left) / 2;
            long totalTime = 0;
            for (int pile: piles) {
                totalTime += (int) Math.ceil((double) pile / speed);
            }

            if (totalTime <= h) {
                min = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }

        }

        return min;
    }
}
