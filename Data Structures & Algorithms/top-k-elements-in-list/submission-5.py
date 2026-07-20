class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # brute force: find how often each int appears, sort the counts
        # get the top k counts from back of the list
        # how to count each ints? -> use a dict

        # Step 1: Find how often each int appears
        # map = {}
        # for num in nums:
        #     if num not in map:
        #         map[num] = 0
            
        #     map[num] += 1
        
        # # Step 2: Sort the counts
        # arr = []
        # for key, val in map.items():
        #     arr.append([val, key])
        # arr.sort()

        # # Step 3: Get the top k frequents
        # res = []
        # while len(res) < k:
        #     res.append(arr.pop()[1])
        
        # return res

        # 2nd Solution:
        # how can we improve from O(nlogn)? -> don't use sort()
        # solution: keep the map with the counts, instead of a sorted arr, we can use a priority queue (heap)
        # this way, we can filter the counts; pushing to a pq is log(n) where n is size of heap
        # we can reduce the size of the heap to be at most k elements because we only want top k frequent
        # this makes it O(logk) and the overall solution O(nlogk)

        # Step 1: Get the frequencies of each number
        map = {}
        for num in nums:
            if num not in map:
                map[num] = 0
            
            map[num] += 1
        
        # Step 2: Implement the PQ and Append/Pop from the PQ
        pq = []
        for num in map.keys():
            heapq.heappush(pq, (map[num], num)) # (count of num, num)

            # Step 3: Keep At Most Size k in the PQ
            if len(pq) > k:
                heapq.heappop(pq)
        
        # Step 4: Convert to Array
        res = []
        for i in range(k):
            res.append(heapq.heappop(pq)[1])
        
        return res
        


        