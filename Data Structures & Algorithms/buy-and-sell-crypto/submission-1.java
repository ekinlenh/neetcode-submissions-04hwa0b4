class Solution {
    public int maxProfit(int[] prices) {
        // loop through prices array
        // set up a day to buy through determining lowest price
        // set up a day to sell through determining highest price
        // sell date must be at a later index than buy date
        // profit = sell_day price - buy_day price

        int buyPrice = prices[0], sellPrice = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            sellPrice = prices[i + 1];
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            
            maxProfit = Math.max(sellPrice - buyPrice, maxProfit);
        }

        return maxProfit;
    }
}
