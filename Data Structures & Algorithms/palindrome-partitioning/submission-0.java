class Solution {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int index, List<String> list) {
        // two options: make new substring, or add to current substring
        if (index >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        char c = s.charAt(index);

        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(s, index, end)) {
                list.add(s.substring(index, end + 1));
                backtrack(s, end + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
