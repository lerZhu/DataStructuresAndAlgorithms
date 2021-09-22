package com.lei.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhulei
 * @create 2021-05-04 23:35
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<Object> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
