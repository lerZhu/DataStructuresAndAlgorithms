package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-04 22:35
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);

        l1.next = l11;
        l11.next = l12;
        l2.next = l21;
        l21.next = l22;

        MergeTwoLists mergeTwoLists  = new MergeTwoLists();
        ListNode node = mergeTwoLists.mergeTwoLists(l1, l2);

        SortList.list(node);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
