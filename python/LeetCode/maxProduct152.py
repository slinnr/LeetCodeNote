class Solution(object):
    def maxProduct(self, nums):
        """
        dp解法。关键点在于状态最大值*一个负数会变成最小值，最小值乘以一个负数又会变回最大值，
        因此在记录状态时，应该将最大值和最小值都记录下来
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return
        if len(nums) == 1:return nums[0]

        dp = [[0 for i in range(len(nums))] for i in range(2)]
        dp[0][0] = nums[0]
        dp[1][0] = nums[0]
        import sys
        res = -sys.maxint
        for i in range(len(nums)):
            dp[0][i] = max(dp[0][i-1]*nums[i], dp[1][i-1]*nums[i], nums[i])
            res = max(res, dp[0][i])
            dp[1][i] = min(dp[1][i-1]*nums[i], dp[0][i-1]*nums[i], nums[i])
        return res