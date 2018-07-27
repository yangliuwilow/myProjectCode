package com.willow;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者和消费者案例,优化，防止出现虚假唤醒，线程无法停止
 */
public class TestProductorAndConsumerForLock {
    public static void main(String[] args) {
        ClerkForLock clerk = new ClerkForLock();

        ProductorForLock pro = new ProductorForLock(clerk);
        ConsumerForLock cus = new ConsumerForLock(clerk);

        new Thread(pro, "生产者 A").start();
        new Thread(cus, "消费者 B").start();
        new Thread(pro, "生产者 C").start();
        new Thread(cus, "消费者 D").start();
    }
}

//店员 假如只有一个商品位置
class ClerkForLock {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进货
    public void get() {
        lock.lock();
        try {
            while (product >= 1) {//为了避免虚假唤醒问题，应该总是使用在循环中
                System.out.println("产品已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //卖货
    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class ProductorForLock implements Runnable {
    private ClerkForLock clerk;

    public ProductorForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

//消费者
class ConsumerForLock implements Runnable {
    private ClerkForLock clerk;

    public ConsumerForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}