package com.lei.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-30 15:37
 */
public class IsPalindromeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(1);
//
        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;

        boolean palindrome = isPalindrome(head);

        System.out.println(palindrome);

    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                list.add(temp.val);
                break;
            }
            list.add(temp.val);
            temp = temp.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            while (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
