import sys
class Solution(object):
    def maxCount(self, m, n, ops):
        """
        :type m: int
        :type n: int
        :type ops: List[List[int]]
        :rtype: int
        """
        maxA = m
        maxB = n
        for a, b in ops:
            maxA = min(maxA, a)
            maxB = min(maxB, b)
        return maxA*maxB

solution = Solution()
print (solution.maxCount(4,4,[[2,2],[3,3]]))