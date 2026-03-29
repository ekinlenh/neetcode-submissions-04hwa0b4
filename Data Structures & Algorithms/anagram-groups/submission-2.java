class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] cnt = new int[26]; // count frequency of letters

            for (char c: str.toCharArray()) {
                cnt[c - 'a']++;
            }

            String key = Arrays.toString(cnt);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
