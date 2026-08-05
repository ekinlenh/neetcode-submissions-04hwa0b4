class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # so for each index i, we traverse to its right till the end of the array
        # comparing the temperatures while keeping count of the number of days
        # until we find a warmer temperature
        # so we can initialize a left pointer (represents temperatures[i]) and
        # initialize a right pointer (represents the days after temperatures[i])
        # brute force approach O(n^2)

        # res = [0] * len(temperatures)
        # for i in range(len(temperatures)):
        #     j = i + 1
        #     days = 1
        #     while j < len(temperatures):
        #         if temperatures[j] > temperatures[i]:
        #             res[i] = days
        #             break
        #         else:
        #             days += 1
        #         j += 1
            
        # return res

        # how can we improve this solution?
        # idea: how can we avoid repetitive right calls?
        # we can use a stack in which we store the indices of the array while traversing
        # the stack will store the most recent index (previous) and we can compare this to 
        # our current index, and if it's warmer, we can set the prev index to the diff between the days
        # we continue this while the stack is not empty and theres a warmer temperature
        # else rest of the days have 0 set instead

        res = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                res[index] = i - index
            stack.append(i)
            
        return res
        

