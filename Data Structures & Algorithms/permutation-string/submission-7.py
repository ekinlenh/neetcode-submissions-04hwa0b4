class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # if len(s1) > len(s2) return false immediately
        # the permutation still has to be a sequence of n letters exactly, just rearranged
        # this means we should keep a window size of n constantly throughout the string
        # we should be checking the counts of s1 to each substring in s2; O(n)
        # if dicts are the same, that means they are permutations of each other and we can return true
        # this is currently O(n * m) where n = len(s2) and m = len(s1)
        # to optimize, we can avoid making substrings and maps in the loop 
        # instead using the sliding window so that we can update an already existing freq map

        if len(s1) > len(s2):
            return False
        
        # freq map of s1
        freq = {}
        for c in s1:
            freq[c] = 1 + freq.get(c, 0)
            
        # count map for window size
        count = {}
        l = 0
        for r in range(len(s2)):
            count[s2[r]] = 1 + count.get(s2[r], 0)
            if (r - l + 1) > len(s1): # we need to move our window
                count[s2[l]] -= 1
                if count[s2[l]] == 0:
                    count.pop(s2[l])
                l += 1
            
            if freq == count:
                return True
        
        return False
