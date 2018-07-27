package com.willow;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}

class Ticket implements Runnable {

    private Lock lock = new ReentrantLock();

    private int tick = 50;

    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tick > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }

                    System.out.println(Thread.currentThread().getName() + "完成售票,余票为: " + --tick);
                } else {
                    break;
                }

            } finally {
                lock.unlock();
            }
        }
    }
}