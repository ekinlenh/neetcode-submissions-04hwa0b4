class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # area = min(heights[i], heights[j]) * (j - i)
        # then we want to keep track of a max_area = max(max_area, area)
        # how should we traverse through the areas to get the max area?
        # idea: since we always want a max area, we should keep 
        # the taller bar while changing the smaller bar to see if there are better options
        # we can continue this throughout the array to get max area

        max_area = 0

        left = 0
        right = len(heights) - 1
        while (left < right):
            base = right - left
            height = min(heights[left], heights[right])

            area = base * height
            max_area = max(max_area, area)

            if heights[left] > heights[right]:
                right -= 1
            else:
                left += 1
        
        return max_area
