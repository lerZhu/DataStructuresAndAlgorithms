package com.lei.solution;

import java.util.Stack;

/**
 * @author zhulei
 * @create 2021-04-30 15:09
 */
public class ReverseList {
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

        SortList.list(head);

        ListNode node = reverseList(head);

        SortList.list(node);

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //创建一个新的空的头结点
        ListNode newHead = new ListNode();
        /*
        遍历原链表
        取出原链表的每一个节点加入到新的头结点后面
         */
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }
        //把新头结点的下一个节点给原头结点
        head = newHead.next;
        return head;
    }
}
