class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # brute force: traverse through list, sort string alphabetically
        # store this sorted string our a hashmap

        groups = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key not in groups:
                groups[key] = []
            groups[key].append(s)
        
        return list(groups.values())