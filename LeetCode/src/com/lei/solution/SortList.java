package com.lei.solution;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author zhulei
 * @create 2021-04-29 23:02
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        list(head);

        ListNode node = sortList(head);

        list(node);

    }

    public static void list(ListNode head) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动，我们需要一个辅助遍历temp
        ListNode temp = head;
        //遍历，找到链表最后一个节点
        while (true) {
            //找到链表最后
            if (temp == null){
                break;
            }else {
                //没有找到，将temp后移
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                list.add(temp.val);
                break;
            }
            list.add(temp.val);
            temp = temp.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        head = new ListNode(list.get(0));
        temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return head;
    }
}


class ListNode{
    int val;
    ListNode next;

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