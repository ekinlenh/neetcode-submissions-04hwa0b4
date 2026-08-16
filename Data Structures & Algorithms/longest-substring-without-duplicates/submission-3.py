class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # variable sliding window
        # idea: we start with the first character then move onto the second
        # if the second character is not a duplicate (use a set), then we continue moving
        # to the next character and increasing the current length until we do find a dupe
        # once there's a dupe, we move from the left as many times as we need until there's no longer a dupe
        # and continue this process until we go through the whole string

        if len(s) == 0:
            return 0

        max_length = 0
        left = 0
        right = left
        seen = set()
        while right < len(s):
            if s[right] not in seen:
                seen.add(s[right])
                max_length = max(max_length, right - left + 1)
                right += 1
            else:
                seen.remove(s[left])
                left += 1
        
        return max_length
