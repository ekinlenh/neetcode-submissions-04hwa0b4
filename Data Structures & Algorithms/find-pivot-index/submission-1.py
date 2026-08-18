class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        # idea: trefix sums
        # at an index i, we have two matrices left_sum[] and right_sum[]
        # left_sum[] represents the sum to index i from its left
        # right_sum[] represents the sum from index i to its right
        # we find when left_sum == right_sum, else return -1

        left_sum = [0] * len(nums)
        for i in range(1, len(nums)):
            left_sum[i] = nums[i - 1] + left_sum[i - 1]
        
        right_sum = [0] * len(nums)
        for i in range(len(nums) - 2, -1 , -1):
            right_sum[i] = nums[i + 1] + right_sum[i + 1]
        
        for i in range(len(nums)):
            if left_sum[i] == right_sum[i]:
                return i
        
        return -1