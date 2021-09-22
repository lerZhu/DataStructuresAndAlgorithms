package com.lei.swordfingeroffer;

import com.lei.datastr.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-07-21 0:37
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(n - i);
        }
        return result;
    }
}
