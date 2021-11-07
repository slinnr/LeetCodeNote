
"""
做法：两个节点，之间相距n。后面那个到了终点，前面那个就是要删除的节点
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        preNode = head
        afterNode = head

        for i in range(n):
            afterNode = afterNode.next
        if not preNode.next:
            return None
        if not afterNode:
            return head.next
        while afterNode and afterNode.next:
            preNode = preNode.next
            afterNode = afterNode.next
        preNode.next = preNode.next.next
        return head

node1 = ListNode(1)
node2 = ListNode(2)
# node3 = ListNode(3)
# node4 = ListNode(4)
# node5 = ListNode(5)
node1.next = node2
# node2.next = node3
# node3.next = node4
# node4.next = node5
solution = Solution()
node = solution.removeNthFromEnd(node1 , 2)

while node:
    print(node.val)
    node = node.next

