"""使用动态规划。表达式为：二叉树的数量等于左边子树乘以右边子树"""
class Solution:
    def numTrees(self, n: int) -> int:
        if n == 0 or n == 1:
            return 1
        num = [0 for i in range(n+1)]
        num[0] = 1
        num[1] = 1
        for i in range(2,n+1):
            for j in range(i):
                num[i]+=(num[j]*num[i-j-1])
        return num[n]