class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String (charArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
