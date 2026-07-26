class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # we need to check all potential triplets
        # brute force solution would be 3 for loops (O(n^3)) -> how to improve?
        # sorting the array would be good because it allows us to do the same thing as previous leetcode
        # we want something like nums[i] + nums[left] + nums[right] == 0
        # so maybe have an outer for loop (i) and then traverse with left and right?
        res = []

        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]: # prevent dupes
                continue

            left = i + 1
            right = len(nums) - 1
            while (left < right):
                target = nums[i] + nums[left] + nums[right]
                if (target == 0):
                    triplet = [nums[i], nums[left], nums[right]]
                    # if triplet not in res: # Changing this because this ruins time complexity
                    #     res.append(triplet)
                    res.append(triplet)
                    left += 1
                    right -= 1

                    # Fix: when we move left and it's the same as prev index, we know it's a dupe
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                elif (target > 0):
                    right -= 1
                else:
                    left += 1
                
        return res
        