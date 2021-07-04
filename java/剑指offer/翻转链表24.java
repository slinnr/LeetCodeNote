package main.Java.com.sunlin.剑指offer;

public class 翻转链表24 {
    public static void main(String[] args) {
        翻转链表24 reverse = new 翻转链表24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode resNode = reverse.reverseList(node1);
        reverse.printNodeList(resNode);

    }
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode reversedHead = null;
        ListNode preNode = new ListNode(0);
        ListNode nextNode = new ListNode(0);

        preNode = head;
        ListNode midNode = preNode.next;
        nextNode = midNode.next;
        head.next = null;
        while (true){
            midNode.next = preNode;
            preNode = midNode;
            midNode = nextNode;
            nextNode = nextNode.next;

            if (nextNode == null){
                midNode.next = preNode;
                reversedHead = midNode;
                return reversedHead;
            }
        }
    }

    private void printNodeList(ListNode node){
        System.out.println(node.val);

        if (node.next == null){
            return;
        }
        printNodeList(node.next);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
