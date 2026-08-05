class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # so for each index i, we traverse to its right till the end of the array
        # comparing the temperatures while keeping count of the number of days
        # until we find a warmer temperature
        # so we can initialize a left pointer (represents temperatures[i]) and
        # initialize a right pointer (represents the days after temperatures[i])
        # brute force approach

        res = [0] * len(temperatures)
        for i in range(len(temperatures)):
            j = i + 1
            days = 1
            while j < len(temperatures):
                if temperatures[j] > temperatures[i]:
                    res[i] = days
                    break
                else:
                    days += 1
                j += 1
            
        return res
