import sys
from typing import List

"""从下往上遍历，找到从底部到当前位置的最短路径，直到到顶点"""
class Solution:
    res = sys.maxsize
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return
        for line in reversed(range(len(triangle)-1)):
            for index in range(len(triangle[line])):
                triangle[line][index] += min(triangle[line+1][index],triangle[line+1][index+1])

        return triangle[0][0]