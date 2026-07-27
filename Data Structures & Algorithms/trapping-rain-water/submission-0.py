class Solution:
    def trap(self, height: List[int]) -> int:
        # similar to container with most water
        # difficult part about this problem is how do we determine the area
        # of the zone [3, 1, 0, 1, 3]?
        # for each column, the amount of water that can be filled up is 
        # dependent on the max height of the left bar and the right bar
        # i.e. current bar = 0, left = 3, right = 3 -> we can trap 3 blocks
        # so the water[i] = min(max_left, max_right) - height[i] (must be positive)
        # now the problem is how do we find the max_left and max_right?
        # we could create two arrays left and right
        # left stores the tallest bar from the beginning to index i
        # similarly right stores tallest bar from end to index i
        # this is similar approach to the product of array except self where we use suffix/prefix arrays

        n = len(height)
        leftMax = [0] * n 
        for i in range(n):
            if i == 0:
                leftMax[i] = height[i]
            else:
                leftMax[i] = max(leftMax[i - 1], height[i])
        
        rightMax = [0] * n
        for i in range(n - 1, -1, -1):
            if i == (n - 1):
                rightMax[i] = height[i]
            else:
                rightMax[i] = max(rightMax[i + 1], height[i])
        
        water = 0
        for i in range(n):
            water += min(leftMax[i], rightMax[i]) - height[i]
        
        return water
        


