from typing import List
"""将序列转化为树问题，然后进行dfs操作"""
class Solution:
    res = []
    def generateParenthesis(self, n: int) -> List[str]:

        if n < 1:
            return
        self.dfs("(",n-1,n)
        return self.res

    def dfs(self,path,left,right):
        if right == 0 and left == 0:
            self.res.append(path)
            return
        if right<left or right < 0 or left < 0:
            return
        self.dfs(path+"(",left-1,right)
        self.dfs(path+")",left,right-1)