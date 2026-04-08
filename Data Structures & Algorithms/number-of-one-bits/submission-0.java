class Solution {
    public int hammingWeight(int n) {
        
        // n = 8 --> 1000
        // n = n & (n - 1) --> 1000 & 0111 --> 0000
        // returns 1 bit 
        
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }
}
