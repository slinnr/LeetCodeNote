class Solution(object):
    def rob(self, nums):
        """
        dp。注意初始条件应该写到第三个。
        当前应该偷第i家或者i-1家中最大收益的那一家
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        dp = [0 for i in range(len(nums)+1)]
        dp[0] = 0
        dp[1] = nums[0]
        dp[2] = max(nums[0], nums[1])
        res = dp[2]
        for i in range(2, len(nums)):
            dp[i+1] = max(dp[i-1]+nums[i],dp[i-2]+nums[i-1])
            res = max(dp[i+1], res)
        return res