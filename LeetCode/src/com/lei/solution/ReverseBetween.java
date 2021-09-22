package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-07 23:30
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseBetween demo = new ReverseBetween();

        ListNode node = demo.reverseBetween(head, 3, 4);

        SortList.list(node);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode temp = head;
        ListNode newHead = new ListNode();
        ListNode newTemp = newHead;
        //将开始反转的节点前面的节点加入到新链表中
        for (int i = 1; i < left; i++) {
            newTemp.next = temp;
            temp = temp.next;
            newTemp = newTemp.next;
        }
        //保存开始反转的节点
        ListNode leftNode = temp;
        //反转left-right的链表
        for (int i = left; i <= right; i++) {
            ListNode curr = temp.next;
            temp.next = newTemp.next;
            newTemp.next = temp;
            temp = curr;
        }
        //将right后面的链表加入新链表尾部
        leftNode.next = temp;
        return newHead.next;
    }
}
