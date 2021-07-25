class Solution(object):
    def jump(self, nums):
        """
        贪心算法。维护两个距离，当前覆盖的最远距离，下一步覆盖的最远距离。
                如果遍历到当前覆盖的最远距离但是没有到终点，那就步数加一，把当前覆盖的最远距离变为下一步覆盖的最远距离
                如果当前覆盖的最远距离到重点了，返回步数
                下一步的最远距离是便利过程中最大的那个i+nums[i]
                如果下一步的最远距离到终点了，返回步数+1

        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 1:
            return 0
        curDistance = nums[0]
        nextDistance = nums[0]
        step = 1
        for i in range(len(nums)):
            if i > curDistance:
                curDistance = nextDistance
                step += 1
            if curDistance >= len(nums)-1:
                return step
            nextDistance = max(i+nums[i], nextDistance)
            if nextDistance >= len(nums)-1:
                return step+1
        return step