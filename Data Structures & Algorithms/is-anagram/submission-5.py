class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 2 words are anagrams if they have same letter count
        # how do we check this? -> use a hashmap
        # key stores letter, value stores count
        # edge case: s and t are not same length or are empty

        if not s or not t:
            return False
        
        if len(s) != len(t):
            return False

        s_map = {}
        t_map = {}

        for i in range(len(s)):
            s_map[s[i]] = s_map.get(s[i], 0) + 1
            t_map[t[i]] = t_map.get(t[i], 0) + 1

        return s_map == t_map