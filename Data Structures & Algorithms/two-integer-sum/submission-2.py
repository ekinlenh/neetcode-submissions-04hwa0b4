class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # brute force: loop through nums with i and j, checking all pairs
        # O(n^2) time complexity

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        
        return [0, 0]