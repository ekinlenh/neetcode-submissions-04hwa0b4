class Solution:
    def isPalindrome(self, s: str) -> bool:
        # use a pointer from the start and the end
        # if either pointer is at a space, then move to next character before checking
        # then we can just check if start and end pointers are equal, else return false
        # also make all letters lowercase and check if each char is an alphanumeric char
        # we can do this by checking for ascii values
        def checkValid(s, index):
            c = s[index]

            if (ord(c) >= 97 and ord(c) <= 122) or (ord(c) >= 48 and ord(c) <= 57):
                return True

            return False

        left = 0
        right = len(s) - 1

        s = s.lower()

        while left < right:
            while left < right and not checkValid(s, left):
                left += 1
            while left < right and not checkValid(s, right):
                right -= 1
            
            if s[left] != s[right]:
                return False
            
            left += 1
            right -= 1
        
        return True
        