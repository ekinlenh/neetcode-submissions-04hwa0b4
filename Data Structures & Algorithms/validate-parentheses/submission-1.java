class Solution {
    public boolean isValid(String s) {
        // use a stack with a hashmap 
        // hashmap keeps track of closed and open brackets of the same type
        // stack will store only open brackets
        // because of LIFO, stack.peek() should always get the first bracket to 
        // kick out
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> closedToOpen = new HashMap<>();
        closedToOpen.put(')', '(');
        closedToOpen.put(']', '[');
        closedToOpen.put('}', '{');

        for (char c: s.toCharArray()) {
            if (closedToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closedToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        //simply return if stack is empty or not
        return stack.isEmpty();
    }
}
