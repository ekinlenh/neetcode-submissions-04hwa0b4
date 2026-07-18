class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # brute force: traverse through list, sort string alphabetically
        # use a hashmap to store that key value
        # key: alphabetical word, value: list
        # then for each key, we simply add its list to a list of string lists

        map = {}

        for s in strs:
            string = "".join(sorted(s))

            if string not in map:
                map[string] = []

            map[string].append(s)
        
        return list(map.values())