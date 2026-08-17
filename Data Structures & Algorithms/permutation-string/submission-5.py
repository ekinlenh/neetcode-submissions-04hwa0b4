class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # if len(s1) > len(s2) return false immediately
        # the permutation still has to be a sequence of n letters exactly, just rearranged
        # this means we should keep a window size of n constantly throughout the string
        # we should be checking the counts of s1 to each substring in s2; O(n)
        # if dicts are the same, that means they are permutations of each other and we can return true

        if len(s1) > len(s2):
            return False
        
        # freq map of s1
        freq = {}
        for c in s1:
            freq[c] = 1 + freq.get(c, 0)
            
        # do first window
        count = {}
        for c in s2[:len(s1)]:
            if c not in count:
                count[c] = 0
            count[c] += 1
        
        if freq == count:
            return True
        
        # now check rest of windows
        r = len(s1)
        for l in range(1, len(s2) - len(s1) + 1):
            print(l, r)
            sub = s2[l:r + 1]
            count = {}
            for c in sub:
                count[c] = 1 + count.get(c, 0)
            if freq == count:
                return True
            
            r += 1
        
        return False
