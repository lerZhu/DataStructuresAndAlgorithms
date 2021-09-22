package com.lei.datastr;

/**
 * @author zhulei
 * @create 2021-07-21 0:38
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + val +
                '}';
    }
}
