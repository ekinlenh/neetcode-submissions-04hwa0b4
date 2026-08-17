class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # idea: 
        # we use a variable sliding window
        # use a left and right pointer
        # start at first character, since left == right -> move to second char
        # if second char matches, increase current length and move to third
        # if doesn't match, use a replacement and now you have k - 1 replacements allowed, then move to next
        # once right != left AND k == 0 for that sequence, compare length with maxLength and go to next window
        n = len(s)
        max_length = 0

        counts = {}
        left = 0
        max_f = 0
        for right in range(len(s)):
            counts[s[right]] = 1 + counts.get(s[right], 0)
            max_f = max(max_f, counts[s[right]])

            while (right - left + 1) - max_f > k:
                counts[s[left]] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)

        return max_length