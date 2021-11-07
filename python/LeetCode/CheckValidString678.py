import collections

class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        leftDeque = collections.deque()
        starDeque = collections.deque()

        for index in range(len(s)):
            if s[index] == '(':
                leftDeque.append(index)
            elif s[index] == ")":
                if len(leftDeque):
                    leftDeque.pop()
                elif len(starDeque):
                    starDeque.pop()
                else:
                    return False
            else:
                starDeque.append(index)

        while len(starDeque) and len(leftDeque):
            left = leftDeque.pop()
            star = starDeque.pop()
            if left > star:
                return False
        if leftDeque:
            return False
        return True

solution = Solution()
s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
print(solution.checkValidString(s))