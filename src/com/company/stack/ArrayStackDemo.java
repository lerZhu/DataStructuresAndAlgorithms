package com.company.stack;

/**
 * @author zhulei
 * @create 2021-04-08 13:00
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.list();
        System.out.println();
        arrayStack.pop();
        arrayStack.list();
    }
}

class ArrayStack{

    //栈最大容量
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //top表示栈顶，初始为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //遍历,从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top;i >= 0;i--){
            System.out.println(stack[i]);
        }
    }

    //入栈
    public void push(int data){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = data;
    }

    //出栈
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }
}
