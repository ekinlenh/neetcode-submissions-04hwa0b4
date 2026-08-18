class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        # idea: trefix sums
        # at an index i, we have two matrices left_sum[] and right_sum[]
        # left_sum[] represents the sum to index i from its left
        # right_sum[] represents the sum from index i to its right
        # we find when left_sum == right_sum, else return -1

        left_sum = [0] * len(nums)
        for i in range(0, len(nums)):
            if i == 0:
                left_sum[i] = nums[i]
            else:
                left_sum[i] = nums[i] + left_sum[i - 1]
        
        right_sum = [0] * len(nums)
        for i in range(len(nums) - 1, -1 , -1):
            if i == len(nums) - 1:
                right_sum[i] = nums[i]
            else:
                right_sum[i] = nums[i] + right_sum[i + 1]
        
        print(left_sum)
        print(right_sum)
        for i in range(len(nums)):
            if left_sum[i] == right_sum[i]:
                return i
        
        return -1