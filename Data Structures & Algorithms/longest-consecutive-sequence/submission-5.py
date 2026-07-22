class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # sets have O(1) lookups, we can add all ints to a set
        # and then traverse through the list while the current num + 1 exists
        # and we continue for all nums and keep the max length
        # problem: this is O(n^2) time complexity but we need O(n)
        # solution: instead of checking for each num in nums, 
        # what if we only check longest consecutive sequence starting from a starting number
        # i.e. num - 1 does not exist in the set
        # therefore we cut time costs but only counting from starting numbers

        s = set()
        longest = 0

        for num in nums:
            s.add(num)

        for num in nums:
            length = 0
            if num - 1 not in s:
                while num + length in s:
                    length += 1
            
            longest = max(longest, length)
        
        return longest

        