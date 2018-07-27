package com.willow;


/**
 *  一、volatile  关键词，当多个线程操作共享数据时，可以保证内存中的数据可见，
 *       性能低，比synchronized的效率高，修饰后不能重排序,修饰的数据存储到主存中
 *
 *     未用volatile 修饰的关键词：
 *          分别存储到线程A的内存，线程B内存，和主内存中，线程A修改后，同步到主存中，线程b没有及时更新(仍然读取的自己线程缓存的数据)
 *
 * 注意：
 *      1.valatile ，不具备"互斥性"
 *      2.valatile ,不能保证变量的“原子性”
 *
 *
 */
public class TestVolatitle {

    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        new Thread(threadDemo).start();
        while(true){
            synchronized (threadDemo) {
                if (threadDemo.isFalg()) {
                    System.out.println("---------");
                    break;
                }
            }
        }
    }
}

class ThreadDemo implements  Runnable{


   private  volatile boolean falg=false;

   @Override
   public void run() {
       try {
           Thread.sleep(200);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       falg=true;
       System.out.println("falg"+falg);
   }


    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }
}