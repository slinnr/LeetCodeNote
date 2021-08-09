
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        循环两次，第二次循环时，找到可能是最大长度的那个值，然后+1，再与当前长度比较，取较大的那个
        """
        length = len(nums)
        dp = [1 for i in range(length)]
        res = 1
        for index in range(length):
            for i in reversed(range(index)):
                if nums[i] < nums[index]:
                    dp[index] = max(dp[i]+1, dp[index])
                    res = max(dp[index], res)
        return res

nums = [10,9,2,5,3,7,101,18]
nums = [7,7,7,7,7,7,7]
nums = [0,1,0,3,2,3]
nums = [2,2]
solution = Solution()
print(solution.lengthOfLIS(nums))
