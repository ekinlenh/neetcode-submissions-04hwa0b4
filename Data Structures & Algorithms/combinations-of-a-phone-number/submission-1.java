class Solution {

    List<String> res = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        // hashmap to store number to letter set
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int index, String s) {
        if (index >= digits.length()) {
            res.add(s);
            return;
        }

        // choose one of the letters, then go to next index and repeat
        // "34" -> 3 is "DEF", choose "D" -> 4 is "GHI", choose "G", "H", "I"
        // then backtrack to original decision, choose "E", repeat
        // then backtrack to original decision, choose "F", repeat
        for (int i = 0; i < map.get(digits.charAt(index)).length(); i++) {
            backtrack(digits, index + 1, s + map.get(digits.charAt(index)).charAt(i));

        } 
    }
}
