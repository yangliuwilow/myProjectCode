package com.willow;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一、i++ 原子可见性：i++ 的操作实际上分为三个步骤 “读” ，“改”，“写”
 *      int i =10;
 *      i=i++; //10
 *      int temp=i;
 *      i=i+1 ;
 *      i=temp;
 *
 * 二、原子变量：  jdk1.5后，java.util.concurrent.atomic  包下提供了常用的原子变量
 *         1.  volatile  保证内存可见性
 *         2.CAS   保证数据的原子性 ：
 *            CAS 算法是硬件对并发操作的共享数据的支持
 *            CAS包含了三个操作数：
 *            内存值 V
 *            预估值（旧值） A
 *            更新值：B
 *            当且仅当 V==A 时，才赋值 V=B ，否则，不做任务操作
 *
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicThread atomicThread = new AtomicThread();
        for (int i = 0; i <10 ; i++) {
            new Thread(atomicThread).start();
        }

    }

}

class AtomicThread implements   Runnable{

   // public volatile Integer sn=0;
    private AtomicInteger sn=new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(add());
    }

    public Integer add(){
        return sn.getAndIncrement();
    }
}