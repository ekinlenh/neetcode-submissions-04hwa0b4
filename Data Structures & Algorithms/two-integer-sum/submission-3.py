class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # brute force: loop through nums with i and j, checking all pairs
        # O(n^2) time complexity

        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        
        # return [0, 0]

        # how to improve this solution?
        # for each index, we store the difference between target and nums[index] in a dict
        # then as we traverse through the list, we check if we have this value in the dict
        # we store key = difference, value = index
        
        map = {}

        for i in range(len(nums)):
            if nums[i] in map:
                return [map[nums[i]], i]

            diff = target - nums[i]
            map[diff] = i
        
        return [0, 0]