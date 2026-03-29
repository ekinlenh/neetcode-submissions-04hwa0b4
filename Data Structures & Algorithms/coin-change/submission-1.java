class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // height of tree is the number of coins needed
        // start with index 0 of the array
        // option to include or not
        // we can continue with this index or move onto next index
        // where we have the same options
        // i.e. 12 -> 1 + 1 + 5 + 5 = 12, 1 + 1 + 10 = 12
        // find the min length tree of this
        // exploring 2^amount options

        int[][] memo = new int[amount + 1][coins.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        // store each state so we don't repeat outcomes
        // i.e. memo[10][0] means we want to fill 10 coins and we are at index 0
        // solution: O(amount x coins.length)

        int fewestCoins = coinChangeHelper(coins, memo, amount, 0);
        if (fewestCoins == Integer.MAX_VALUE) {
            return -1;
        }
        return fewestCoins;
    }

    private int coinChangeHelper(int[] coins, int[][] memo, int amount, int index) {
        if (amount < 0 || index >= coins.length) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount][index] != -1) {
            return memo[amount][index];
        }

        int use = coinChangeHelper(coins, memo, amount - coins[index], index);
        int skip = coinChangeHelper(coins, memo, amount, index + 1);

        if (use != Integer.MAX_VALUE) {
            use += 1;
        }

        return Math.min(use, skip);

    }
}
