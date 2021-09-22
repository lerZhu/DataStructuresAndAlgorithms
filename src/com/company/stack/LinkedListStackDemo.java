package com.company.stack;

/**
 * @author zhulei
 * @create 2021-04-08 13:26
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.list();
        System.out.println();

        linkedListStack.pop();
        linkedListStack.list();
    }
}

class LinkedListStack{

    private LLNode top;

    //入栈
    public void push(int data) {
        LLNode node = new LLNode(data);
        if (top == null) {
            top = node;
        }else {
            node.setNext(top);
            top = node;
        }
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int data = top.getData();
        top = top.getNext();
        return data;
    }

    //输出栈顶元素，不是出栈
    public int showTop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return top.getData();
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        LLNode temp = top;
        while (true) {
            if (temp.getNext() == null) {
                System.out.println(temp.getData());
                break;
            }
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    //栈空
    public boolean isEmpty() {
        return top == null;
    }
}

class LLNode{

    private int data;
    private LLNode next;

    public LLNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LLNode{" +
                "data=" + data +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}