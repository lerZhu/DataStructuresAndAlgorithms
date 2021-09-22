package com.lei.swordfingeroffer;

import com.lei.datastr.ListNode;

/**
 * @author zhulei
 * @create 2021-07-21 21:41
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        deleteNode(head,3);

    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode temp = preHead;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return preHead.next;
    }
}
