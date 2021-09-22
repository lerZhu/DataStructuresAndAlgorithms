package com.lei.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-05-07 20:19
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthFromEnd demo = new RemoveNthFromEnd();
        ListNode node = demo.removeNthFromEnd(head, 2);
        SortList.list(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //如果只有头节点，则必然删除头结点
        if (head.next == null) {
            return null;
        }
        ListNode temp = head;
        //获得链表的长度
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        temp = head;
        //如果删除的是头结点，直接返回head.next
        if (n == length) {
            head = head.next;
            return head;
        }

        //遍历到要删除节点的前一个节点
        for (int i = 0; i < length - n - 1; i++) {
            temp = temp.next;
        }

        //如果要删除的节点是最后一个节点
        if (temp.next.next == null) {
            temp.next = null;
        }else {
            //不是最后一个节点
            temp.next = temp.next.next;
        }

        return head;
    }
}
