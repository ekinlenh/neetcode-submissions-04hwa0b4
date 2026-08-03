import operator

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # idea: append to stack until reach operator
        # then we can calculate the result of the expression,
        # and append that back into the stack and continue this process
        # ex: stack (top -> bot )= [1] -> stack = [2,1] -> 1 - 2 = -1 -> stack = [-1]
        # should at most be two elements in the stack
        operators = {
            "+": operator.add,
            "-": operator.sub,
            "*": operator.mul,
            "/": operator.truediv
        }

        stack = []
        for token in tokens:
            if token in operators:
                num2 = int(stack.pop())
                num1 = int(stack.pop())
                res = operators[token](num1, num2)
                stack.append(res) 
            else:
                stack.append(token)
        
        return int(stack.pop())
