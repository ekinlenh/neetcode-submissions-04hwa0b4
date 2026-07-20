class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # brute force: find how often each int appears, sort the counts
        # get the top k counts from back of the list
        # how to count each ints? -> use a dict

        # Step 1: Find how often each int appears
        map = {}
        for num in nums:
            if num not in map:
                map[num] = 0
            
            map[num] += 1
        
        # Step 2: Sort the counts
        arr = []
        for key, val in map.items():
            arr.append([val, key])
        arr.sort()

        # Step 3: Get the top k frequents
        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        
        return res

        