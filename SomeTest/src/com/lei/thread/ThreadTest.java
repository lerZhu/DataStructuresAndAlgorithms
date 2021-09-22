package com.lei.thread;

/**
 * @author zhulei
 * @create 2021-04-22 20:28
 */
public class ThreadTest extends Thread {
    public static void main(String[] args) throws InterruptedException {

        ThreadRunnable thread1 = new ThreadRunnable("Thread1");
        ThreadRunnable thread2 = new ThreadRunnable("Thread2");
        Thread thread11 = new Thread(thread1);
        Thread thread12 = new Thread(thread2);
        thread11.start();
        for (int i = 0; i < 100; i++) {
            if (i > 50) {
                thread11.join();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100; i += 2) {
            System.out.println(i);
        }
    }
}