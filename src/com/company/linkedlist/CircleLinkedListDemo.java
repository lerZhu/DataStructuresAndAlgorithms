package com.company.linkedlist;

/**
 * @author zhulei
 * @create 2021-04-08 9:33
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(5);
        circleLinkedList.list();
        System.out.println();

        circleLinkedList.countNode(1,2,5);
    }
}

class CircleLinkedList{

    private CircleNode first = null;

    /**
     * 添加节点，构成一个环形链表
     * @param nums 节点个数
     */
    public void add(int nums){
        if (nums < 1) {
            System.out.println("节点个数不符合要求");
            return;
        }
        //辅助指针，帮助构成环形链表
        CircleNode curNode = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建节点
            CircleNode node = new CircleNode(i);
            //如果是第一个节点
            if (i == 1) {
                first = node;
                //指向自己，构成环
                first.setNext(first);
                //辅助指针指向当前创建的节点
                curNode = first;
            }else {
                //辅助指针指向的是上一个创建的最后一个节点，将新节点连接到尾部
                curNode.setNext(node);
                //新节点连接到第一个节点，构成环
                node.setNext(first);
                //辅助指针指向当前创建的节点，后移
                curNode = node;
            }
        }
    }

    /**
     * 遍历当前链表
     */
    public void list() {
        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }
        //因为first不能动，设置一个辅助指针来完成遍历
        CircleNode curNode = first;
        do {
            if (curNode.next == first){
                System.out.print(curNode.data);
                break;
            }
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }while (curNode != first);
    }

    /**
     * 根据输入，计算出圈顺序
     * @param startNo 从第几号开始数
     * @param countNum 数了多少下
     * @param nums 最初有多少个数
     */
    public void countNode(int startNo,int countNum,int nums){
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入数据错误");
            return;
        }
        //创建辅助指针，
        CircleNode helper = first;
        //创建一个辅助指针变量helper，指向环形链表最后的节点
        while (true) {
            //说明helper指向最后一个节点
            if (helper.next == first) {
                break;
            }
            helper = helper.getNext();
        }
        //计数前，先让first和helper移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //计数是，让first和helper同时向后移动countNum-1次，然后出圈
        while (true) {
            //圈中只有一个节点
            if(helper  == first) {
                System.out.println(first.data);
                break;
            }
            //让first和helper同时向后移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.print(first.data + " -> ");
            first = first.getNext();
            helper.setNext(first);
        }
    }
}

class CircleNode{

    public int data;
    public CircleNode next;

    public void setNext(CircleNode next) {
        this.next = next;
    }

    public CircleNode getNext() {
        return next;
    }

    public CircleNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "data=" + data +
                '}';
    }
}