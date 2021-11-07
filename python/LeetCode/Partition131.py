"""
131. 分割回文串

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。
示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
"""

class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        length = len(s)
        res = []
        ret = []
        self.dfs(s, res, ret, 0)
        return ret

    def dfs(self, s, res, ret, i):
        if i == len(s):
            ret.append(res.copy())
            return
        if self.IsHuiWen(s, index, end):
            res.append(s[index:end+1])



    def IsHuiWen(self, s, index, end):
        substr = s[index : end+1]
        while(s[index] == s[end] and ++index and --end):
            if index > end:
                return True
        return False

s = "aab"
solution = Solution()
print(solution.partition(s))
