package com.lei.thread;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author zhulei
 * @create 2021-04-22 20:38
 */
public class ThreadRunnable implements Runnable {

    private String name;

    public ThreadRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 101; i += 2) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
