package com.lei.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhulei
 * @create 2021-04-30 0:04
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> intersection = new HashSet<>();
        while (headA != null) {
            intersection.add(headA);
            headA = headA.next;
        }
        //向hashSet中添加B链表，如果添加失败则表明找到交点
        while (headB != null) {
            if (!intersection.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
