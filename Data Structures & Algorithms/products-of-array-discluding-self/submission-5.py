class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # rule: can't use division operation
        # idea: the value of output[i] is the product of the elements to its left and to its right
        # ex: [1, 2, 4, 6] -> 1 x (4 x 6) = 1 x 24 = 24 for output[1]
        # so we can break up the problem into solving the left and right arrays from a certain index
        # and then multiply those two products together to get output[i]
        
        # def findSubProducts(nums: List[int]) -> int:
        #     product = 1
        #     for num in nums: 
        #         product *= num
            
        #     return product

        # productArr = [0] * len(nums)
        # index = 0
        # for i in range(len(nums)):
        #     leftProduct = findSubProducts(nums[0:i])
        #     rightProduct = findSubProducts(nums[i+1:])

        #     productArr[index] = leftProduct * rightProduct
        #     index += 1

        # return productArr

        # current solution: O(n^2) but works
        # how can we make this solution better?
        # index = 0: 2 * 4 * 6
        # index = 1: 1 * 4 * 6
        # index = 2: 1 * 2 * 6
        # index = 3: 1 * 2 * 4

        # we are repeating operations like 4 * 6, can we reduce these?
        # what if we can just have a left and right product arr and then fill up productArr at the end
        # so we compute leftProduct of an index i and rightProduct of an index i separately
        # then productArr[i] = leftProduct[i] * rightProduct[i]
        # problem: how can i fill each array in one pass?
        # solution: carry over the product as we traverse so we can keep multiplying
        left = [0] * len(nums)
        for i in range(len(nums)):            
            if i - 1 < 0:
                left[i] = 1
            else:
                left[i] = left[i - 1] * nums[i - 1]
        
        right = [0] * len(nums)
        for i in range(len(nums) - 1, -1, -1):
            if i + 1 > len(nums) - 1:
                right[i] = 1
            else:
                right[i] = right[i + 1] * nums[i + 1]

        # now combine the two arrays for the product array
        res = [0] * len(nums)
        for i in range(len(nums)):
            res[i] = left[i] * right[i]
        
        return res

