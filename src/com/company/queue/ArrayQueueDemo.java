package com.company.queue;

import java.security.Key;
import java.util.Scanner;

/**
 * @author zhulei
 * @create 2021-03-23 22:27
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据");
            System.out.println("g:取出数据");
            System.out.println("h:查看列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println(queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.showHead();
                        System.out.println(head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}


//使用数组模拟队列————编写一个ArrayQueue的类
class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //数组前端下标
    private int front;
    //数组后端下标
    private int rear;
    //存放数据，模拟队列
    private int arr[];

    //构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部
        rear = -1;//指向队列尾部
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是为空
    public boolean isEmpty() {
        return rear == front;
    }

    //给队列添加数据
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        } else {
            rear++;
            arr[rear] = data;
        }
    }

    //获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            front++;
            return arr[front];
        }
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    //显示队列头部数据，不是取数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return arr[front + 1];
    }
}