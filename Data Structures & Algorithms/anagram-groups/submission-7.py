class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # brute force: traverse through list, sort string alphabetically
        # store this sorted string our a hashmap
        # groups = {}
        # for s in strs:
        #     key = ''.join(sorted(s))
        #     if key not in groups:
        #         groups[key] = []
        #     groups[key].append(s)
        
        # return list(groups.values())
        # this is O(n * mlogm) where n = len(strs) and m = longest string
        # how can we optimize this?
        # solution: don't use sorted() because sorting takes too long
        # what do we use instead? -> keep an array as a count for the string
        # this makes our solution O(n + m) time

        groups = {}
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            
            key = tuple(count)
            if key not in groups:
                groups[key] = []
            groups[key].append(s)
        
        return list(groups.values())