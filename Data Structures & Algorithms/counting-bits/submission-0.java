class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            int bits = 0;
            if (i == 0) {
                res[i] = 0;
            } else {
                int temp = i;
                while (temp != 0) {
                    temp = temp & (temp - 1);
                    bits++;
                }
                res[i] = bits;
            }
        }

        return res;
    }
}
