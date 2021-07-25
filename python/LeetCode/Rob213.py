class Solution(object):
    def rob(self, nums):
        """
        和打家劫舍一样的思路，但是需要记录两种状态，1、偷了第一家，但是没法偷最后一家。2、没偷第一家，但是可以偷最后一家。
        然后把这两种状态中最大的那个值return即可
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        if len(nums) < 3:
            return max(nums[0], nums[1])
        dp = [0 for i in range(len(nums)+1)]
        dp2 = [0 for i in range(len(nums)+1)]

        dp[1] = nums[0]
        dp[2] = max(nums[0], nums[1])

        dp2[2] = nums[1]
        dp2[3] = max(nums[1], nums[2])

        res = max( dp[2], dp2[3])

        for i in range(2, len(nums)-1):
            dp[i+1] = max(dp[i-1]+nums[i], dp[i-2]+nums[i-1])
            dp2[i+2] = max(dp2[i]+nums[i+1], dp2[i-1]+nums[i])
            res = max(dp[i+1], dp2[i+2], res)
        return res