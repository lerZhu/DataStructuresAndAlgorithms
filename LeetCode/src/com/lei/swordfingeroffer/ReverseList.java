package com.lei.swordfingeroffer;

import com.lei.datastr.ListNode;

/**
 * @author zhulei
 * @create 2021-07-21 23:34
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
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
