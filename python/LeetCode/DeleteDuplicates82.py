# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        headNode = ListNode(-111)
        headNode.next = head
        prePoint = headNode
        afterPoint = head
        while afterPoint:
            temp = afterPoint.val
            afterPoint = afterPoint.next
            while afterPoint and temp == afterPoint.val:
                afterPoint = afterPoint.next
            if not afterPoint:
                return head
            prePoint = prePoint.next
            afterPoint = afterPoint.next
        return head

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(3)
node5 = ListNode(4)
node6 = ListNode(4)
node7 = ListNode(5)
node8 = ListNode(5)
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
node6.next = node7
node7.next = node8
solution = Solution()
node = solution.deleteDuplicates(node1)

while node:
    print(node.val)
    node = node.next
