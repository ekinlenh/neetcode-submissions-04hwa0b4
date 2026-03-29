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
        // exploring 2^n options
        int fewestCoins = coinChangeHelper(coins, amount, 0);
        if (fewestCoins == Integer.MAX_VALUE) {
            return -1;
        }
        return fewestCoins;
    }

    private int coinChangeHelper(int[] coins, int amount, int index) {
        if (amount < 0 || index >= coins.length) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        int use = coinChangeHelper(coins, amount - coins[index], index);
        int skip = coinChangeHelper(coins, amount, index + 1);

        if (use != Integer.MAX_VALUE) {
            use += 1;
        }

        return Math.min(use, skip);

    }
}
