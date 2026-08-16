class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # have a left pointer be the buy point day 
        # then increment a right pointer for the sell day 

        if len(prices) == 1:
            return 0

        max_profit = 0
        prefix = [0] * len(prices)
        prefix[0] = prices[0]
        for i in range(1, len(prices)):
            # get a lower buy price if possible
            if prices[i] < prefix[i - 1]:
                prefix[i] = prices[i] 
            else: # sell stock
                prefix[i] = prefix[i - 1]
                profit = prices[i] - prefix[i - 1]
                max_profit = max(max_profit, profit)
        
        return max_profit