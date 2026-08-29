class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # brute force: nested for loop
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        
        # return [0, 0]
        # this is O(n^2), we can optimize to O(n) by using a hashmap
        # the idea behind this is that at each index we check, 
        # we calculate target - nums[index] = diff
        # if this diff exists in our hashmap, retrieve the index where this number is found
        # else, add nums[index] into our hashmap
        # so the key is the number, the value is the index it's found

        seen = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in seen: # we have this key in our hashmap, retrieve it
                return [seen[diff], i]
            
            # otherwise, add this number and its index to our map for future references
            seen[num] = i
        
        return [-1, -1]
