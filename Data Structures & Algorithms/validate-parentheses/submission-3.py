class Solution:
    def isValid(self, s: str) -> bool:
        # to ensure we have the correct order of open brackets -> close brackets
        # we can use a stack to check because of LIFO
        # so the latest open bracket will be checked the the latest closed bracket
        # to see if they are equal, else it's not valid
        # so for each open bracket, we can add its end bracket to the stack
        # and once we encounter an end bracket, we check with the stack to see if theyre equal
        # the stack should be empty by the end of the traversal

        open_to_end = {
            "[": "]",
            "{": "}",
            "(": ")"
        }

        stack = []
        for c in s:
            if c in open_to_end:
                stack.append(open_to_end[c])
            else: 
                if not stack or stack[-1] != c:
                    return False
                else:
                    stack.pop()

        return not stack