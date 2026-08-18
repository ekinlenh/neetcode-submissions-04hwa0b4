class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # each window when size == k
        # we pop from left
        # we add element from right 
        # we also need a max value from each window
        # how to keep track of this max value?
        # b/c it can be the element popped on left or inside the window
        # naive approach is to get max of nums[start : end + 1], this is O(n)
        # this makes total time complexity O(n^2) which gives us TLE
        # i'm thinking we can use a max-heap (pq) to store max value at any time, this is O(1)
        # maybe if max in heap == element we pop from right, remove that element
        # however if it's not how do we remove this left element in our heap?
        # what if we store both max element and index in the heap?
        # if this index is not in the range of the window, we know we should pop it from our heap

        max_heap = []
        heapq.heapify(max_heap)
                
        res = []

        start = 0
        for end in range(len(nums)):
            # add end value
            heapq.heappush(max_heap, (-nums[end], end))

            # if window is size == k
            if (end - start + 1) == k:
                # find max
                while max_heap[0][1] < start or max_heap[0][1] > end:
                    heapq.heappop(max_heap)

                max_value = -max_heap[0][0]
                res.append(max_value)
                # pop from left
                start += 1
        
        return res
