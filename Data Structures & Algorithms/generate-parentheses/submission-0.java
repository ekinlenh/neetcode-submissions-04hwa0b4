class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack("", n);
        return res;
    }

    private void backtrack(String str, int n) {
        if (str.length() == 2 * n) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        backtrack(str + "(", n);
        backtrack(str + ")", n);

    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            // check if closing parenthesis
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
