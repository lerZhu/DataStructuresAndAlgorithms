package com.lei.datastr;

/**
 * @author zhulei
 * @create 2021-05-08 22:34
 */
public class MyCircularQueue {
    int[] arr;
    int head;
    int tail;
    int maxSize;

    public MyCircularQueue(int k) {
        arr = new int[k + 1];
        maxSize = k + 1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % maxSize;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % maxSize;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail - 1 + maxSize) % maxSize];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % maxSize == head;
    }
}
