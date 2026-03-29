class Solution {
    public int evalRPN(String[] tokens) {
        // add to a stack until reaching an operator
        // using the operator, pop out from stack
        // calculate numbers inside the stack
        // repeat again until reaching end of tokens
        // return numbers.pop() --> total calculated value

        Stack<Integer> numbers = new Stack<>();

        for (String token: tokens) {
            if ("+-*/".contains(token)) {
                int val2 = numbers.pop();
                int val1 = numbers.pop();
                int result = calculate(token, val1, val2);
                numbers.push(result);
            } else {
                numbers.push(Integer.parseInt(token)); 
            }
        }

        return numbers.pop();
    }

    private int calculate(String operator, int val1, int val2) {
        switch (operator) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;              
            case "*":
                return val1 * val2;       
            case "/":
                return val1 / val2;         
            default:
                return 0;
            }
    }
}
