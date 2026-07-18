class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # brute force: traverse through list, sort string alphabetically
        # use a hashmap to store that key value
        # key: alphabetical word, value: list
        # then for each key, we simply add its list to a list of string lists

        # map = {}

        # for s in strs:
        #     string = "".join(sorted(s))

        #     if string not in map:
        #         map[string] = []

        #     map[string].append(s)
        
        # return list(map.values())

        # how to improve the time complexity?
        # is there a way we can not use sorted()? 
        # solution: use a 26 length array that counts the frequency of each letter of the word
        # O(m * n * 26) => O(m * n)

        map = {}

        for s in strs: # m = number of strings in the list
            count = [0] * 26
            for c in s: # n = longest string length
                count[ord(c) - ord('a')] += 1
            
            key = tuple(count)

            if key not in map:
                map[key] = []
            
            map[key].append(s)
        
        return list(map.values())
