import queue
# Definition for a binary tree node.
"""广度优先搜索，然后逐一进行比对，不满足相同的条件的，就返回FALSE"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        return self.bfs(p,q)

    def bfs(self,p,q):
        queue1 = queue.Queue()
        queue1.put(p)
        queue2 = queue.Queue()
        queue2.put(q)
        while not queue1.empty() or not queue2.empty():
            node1 = queue1.get()
            node2 = queue2.get()
            if node2.val != node1.val:
                return False
            elif node1.left and not node2.left:
                return False
            elif not node1.left and node2.left:
                return False
            elif node1.right and not node2.right:
                return False
            elif not node1.right and node2.right:
                return False
            if node1.left:
                queue1.put(node1.left)
            if node1.right:
                queue1.put(node1.right)
            if node2.left:
                queue2.put(node2.left)
            if node2.right:
                queue2.put(node2.right)
        return True

root1 = TreeNode(8)
root2 = TreeNode(8)
left1 = TreeNode(7)
right1 = TreeNode(6)
left2 = TreeNode(7)
right2 = TreeNode(6)
# root1 = TreeNode(8)
# root1 = TreeNode(8)
# root1 = TreeNode(8)
root1.left = left1
root1.right = right1
root2.left = left2
# root2.right = right2
solution = Solution()
print(solution.isSameTree(root1,root2))