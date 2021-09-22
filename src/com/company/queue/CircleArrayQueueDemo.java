package com.company.queue;

import java.util.Scanner;

/**
 * @author zhulei
 * @create 2021-03-24 21:35
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        circleArrayQueue circleArrayQueue = new circleArrayQueue(3);
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
                    circleArrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    circleArrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = circleArrayQueue.getQueue();
                        System.out.println(queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = circleArrayQueue.showHead();
                        System.out.println(head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}


class circleArrayQueue{
    //队列最大容量
    private int maxSize;
    //队列的第一个元素
    private int front;
    //队列最后一个元素的后一个位置
    private int rear;
    //存放数据，模拟队列
    private int arr[];

    public circleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //给队列添加数据
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        } else {
            arr[rear] = data;
            rear = (rear + 1) % maxSize;
        }
    }

    //获取队列数据
    public int getQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        } else {
            int data = arr[front];
            front = (front + 1) % maxSize;
            return data;
        }
    }

    //显示队列所有数据
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }else {
            for (int i = front;i < front + size();i++) {
                System.out.println(arr[i % maxSize]);
            }
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示头部数据
    public int showHead() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }else {
            return arr[front];
        }
    }

}