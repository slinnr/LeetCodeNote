class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        #dp[i][0]表示第i天持有，dp[i][1]表示不持有也不处在冷冻期，dp[i][2]表示第i天处于冷冻期
        三种状态可以互相转换，然后找到最大值
        """
        lenth = len(prices)
        if lenth <= 1:
            return 0
        dp = [[0 for i in range(lenth+1)] for j in range(3)]
        dp[0][0] = -prices[0]
        res = 0
        for i in range(1, lenth):
            dp[0][i] = max(dp[0][i-1], dp[1][i-1] - prices[i])
            dp[1][i] = max(dp[2][i-1], dp[1][i-1])
            dp[2][i] = dp[0][i-1] + prices[i]
            res = max(dp[0][i], dp[1][i], dp[2][i])
        return res
prices = [1,2,3,0,2]
solution = Solution()
res = solution.maxProfit(prices)
print(res)
