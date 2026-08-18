class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # if len(t) > len(s) return ""
        # res = ""
        # res_map = {}
        # sub_map = {}
        # for c in t:
        #     res_map[c] = 1 + res_map.get(c, 0)
        #     sub_map[c] = 0

        # for i in range(len(s)):
        #     count = sub_map.copy()
        #     sub = []
        #     for j in range(i, len(s)):
        #         sub.append(s[j])

        #         if s[j] in count:
        #             count[s[j]] += 1
                
        #         total = 0
        #         for c in count:
        #             if count[c] >= res_map[c]:
        #                 total += 1
                
        #         if total == len(res_map):
        #             if res == "":
        #                 res = ''.join(sub)
        #             else:
        #                 res = ''.join(sub) if len(sub) < len(res) else res
        
        # return res
        # this is O(n^2 * k) where k = number of distinct elements in t
        # how to improve this even more?

        res_map = {}
        sub_map = {}
        for c in t:
            res_map[c] = 1 + res_map.get(c, 0)
            sub_map[c] = 0        
        
        start_idx, end_idx = -1, -1
        total = 0
        start = 0
        for end in range(len(s)):
            if s[end] in sub_map:
                sub_map[s[end]] += 1
                if sub_map[s[end]] == res_map[s[end]]:
                    total += 1
            
            # check if there's enough count for res_map

            while total == len(res_map):
                if start_idx == -1:
                    start_idx = start
                    end_idx = end
                else:
                    curr_length = end_idx - start_idx + 1
                    if end - start + 1 < curr_length:
                        start_idx = start
                        end_idx = end
                
                if s[start] in sub_map:
                    sub_map[s[start]] -= 1
                    if sub_map[s[start]] < res_map[s[start]]:
                        total -= 1
                start += 1
        
        return "" if start_idx == -1 else s[start_idx:end_idx + 1]


