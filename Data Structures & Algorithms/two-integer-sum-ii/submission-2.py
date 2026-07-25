class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # since the array is sorted, we can sum the two pointers (left and right)
        # if the sum is equal to target, return left and right
        # if the sum is greater than target value, decrement the right pointer
        # else, increment the left pointer
        # also need to keep edge case in mind for left != right

        left = 0 
        right = len(numbers) - 1
        while left < right:
            sum = numbers[left] + numbers[right]
            if (sum == target):
                return [left + 1, right + 1]
            elif (sum > target):
                right -= 1
            else:
                left += 1
            
        return [0, 0]
        