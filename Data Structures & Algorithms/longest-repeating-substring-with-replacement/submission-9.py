class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # in a specific window 
        # we want to know what the most frequent character is 
        # because once we do, if (end - start + 1) - most_freq > k,
        # that means we have too many replacements needed in our window
        # and therefore we should expand left until this is satisfied
        # how to keep track of most frequent? -> use a hashmap

        freq = {}
        most_freq = 0
        max_length = 0

        start = 0
        for end in range(len(s)):
            freq[s[end]] = 1 + freq.get(s[end], 0) # update count
            most_freq = max(most_freq, freq[s[end]]) # update freq count

            # since we updated our window size, we want to check if it satisfies condition
            while (end - start + 1) - most_freq > k:
                # expand left
                freq[s[start]] -= 1
                most_freq = max(most_freq, freq[s[end]])
                start += 1
            
            max_length = max(max_length, end - start + 1)
        
        return max_length
