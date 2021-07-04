from typing import List
"""从后往前进行遍历，如果前面的数可以到达末尾，就将末尾截取。否则继续向前遍历，如果最后发现截取的部分没有值了，就返回True"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        step = 0
        for index in reversed(range(len(nums)-1)):
            step += 1
            if nums[index] >= step:
                step=0
            if index == 0 and step != 0:
                return False
        return True