class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # if we want the largest rectangle
        # there are two options when traversing from the left
        # 1. the current bar's height (1 x heights[i])
        # 2. min(heights[i-1], heights[i]) -> but how do we continue this across bars
        # we can use a monotonic increasing stack
        # when we add a lower height, pop from stack until we satisfy the increasing order
        # while also computing max_height at the same time

        max_area = 0
        stack = [] # pair: (height, index)
        for i, h in enumerate(heights):
            start = i
            while stack and stack[-1][0] > h:
                height, index = stack.pop()
                max_area = max(max_area, height * (i - index))
                start = index
            stack.append((h, start))
        
        # for rest of elements in the stack
        for height, i in stack:
            max_area = max(max_area, height * (len(heights) - i))

        return max_area

