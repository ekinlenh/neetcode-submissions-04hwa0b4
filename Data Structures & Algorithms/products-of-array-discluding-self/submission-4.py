class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # rule: can't use division operation
        # idea: the value of output[i] is the product of the elements to its left and to its right
        # ex: [1, 2, 4, 6] -> 1 x (4 x 6) = 1 x 24 = 24 for output[1]
        # so we can break up the problem into solving the left and right arrays from a certain index
        # and then multiply those two products together to get output[i]
        
        def findSubProducts(nums: List[int]) -> int:
            product = 1
            for num in nums: 
                product *= num
            
            return product

        productArr = [0] * len(nums)
        index = 0
        for i in range(len(nums)):
            leftProduct = findSubProducts(nums[0:i])
            rightProduct = findSubProducts(nums[i+1:])

            productArr[index] = leftProduct * rightProduct
            index += 1

        return productArr

        # current solution: O(n^2) but works
