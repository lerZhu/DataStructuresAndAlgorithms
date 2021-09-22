package com.company.linkedlist;

/**
 * @author zhulei
 * @create 2021-04-07 15:37
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        Node node1 = new Node(1123);
        Node node2 = new Node(232);
        Node node3 = new Node(3234);
        Node node4 = new Node(412);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);

        doubleLinkedList.list();
        System.out.println("-------------------------");

        doubleLinkedList.update(node1,11);
        doubleLinkedList.list();
        System.out.println("-------------------------");

        doubleLinkedList.deleteNode(node4);
        doubleLinkedList.list();

    }
}

class DoubleLinkedList{
    private Node head = new Node(0);

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //遍历输出
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点
    //默认添加到链表最后
    public void addNode(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }else {
                temp = temp.next;
            }
        }
        temp.next = node;
        node.pre = temp;
    }

    //修改
    public void update(Node node,int data) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        Node temp = head.next;
        while (temp != null) {
            if (temp.next == null) {
                System.out.println("没找到节点");
                break;
            }
            if(temp.date == node.date){
                temp.date = data;
                break;
            }
            temp = temp.next;
        }
    }

    //删除节点
    public void deleteNode(Node node) {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //找到需要删除的节点
        Node temp = head.next;
        while (true) {
            if(temp.date == node.date){
                //如果是最后一个节点，下面这句话会造成空指针
                if(temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                temp.pre.next = temp.next;
                break;
            }
            if (temp.next == null){
                System.out.println("没找到节点");
                break;
            }
            temp = temp.next;
        }
    }
}

class Node{
    public int date;
    public Node pre;
    public Node next;

    public Node(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                '}';
    }
}