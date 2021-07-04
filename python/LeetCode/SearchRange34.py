from typing import List
"""二分+双指针。注意边界值就好了"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        begin = 0
        end = len(nums)-1
        while(begin<=end):
            index = (begin + end) // 2
            if nums[index] < target:
                begin = index+1
            elif nums[index] == target:
                break
            else:
                end = index-1
        if begin > end:
            return [-1,-1]
        begin = index
        end = index
        while begin != 0 and nums[begin-1] == target:
            begin-=1
        while end != len(nums)-1 and nums[end+1] == target:
            end+=1
        return [begin,end]
