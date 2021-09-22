package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-05 21:39
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);

        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        SortList.list(node);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resHead = new ListNode();
        ListNode tempRes = resHead;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            tempRes.next = new ListNode(temp % 10);
            if (l1 != null)
            l1 = l1.next;
            if (l2 != null)
            l2 = l2.next;
            tempRes = tempRes.next;
        }

        if (carry == 1) {
            tempRes.next = new ListNode(1);
        }

        return resHead.next;
    }
}
