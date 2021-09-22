package com.lei.solution;

import java.util.List;

/**
 * @author zhulei
 * @create 2021-07-14 22:55
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node;
        node.next = node1;
        ListNode newHead = deleteDuplicates(head);
        SortList.list(newHead);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;

        while (temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }

        return head;
    }
}
