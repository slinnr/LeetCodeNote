import sys
# Definition for a binary tree node.
"""搜索树的中序遍历为递增数列"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    res = True
    pre = ""
    def isValidBST(self, root: TreeNode) -> bool:
        self.pre = -sys.maxsize
        if not root.left and not root.right:
            return True
        self.dfs(root)
        return self.res

    def dfs(self,node):
        print(type(self.pre))
        if not self.res or not node:
           return
        self.dfs(node.left)
        if node.val <= self.pre:
            self.res = False
        self.pre = node.val
        print(node.val)

        self.dfs(node.right)