package com.lei.swordfingeroffer;

import com.lei.datastr.Node;

import java.util.HashMap;

/**
 * @author zhulei
 * @create 2021-07-22 23:24
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}
