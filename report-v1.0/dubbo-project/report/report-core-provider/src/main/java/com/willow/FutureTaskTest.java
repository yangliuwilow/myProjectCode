package com.willow;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/4/20.
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //TODO FutureTask 应用案例
        FutureTask<String> futureTask =
                new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数
                    public String call() {
                        try {
                            for (int i = 0; i < 5; i++) {
                                Thread.sleep(1000);
                                System.out.println("------------------------" + i);
                            }
                        } catch (InterruptedException e) {
                            System.out.println("InterruptedException1111111");
                            e.printStackTrace();
                        }
                        //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                        return "call result";
                    }
                });
        executor.execute(futureTask);
        //在这里可以做别的任何事情
        try {
            String result = futureTask.get(3000, TimeUnit.MILLISECONDS);
            //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
            System.out.println("___________" + result + "_______________");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException222222");
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            System.out.println("InterruptedException333333333");
            futureTask.cancel(true);
        } catch (TimeoutException e) {
            System.out.println("!!!!!!!!Time out!!!!!!!!!!");
             futureTask.cancel(true);
        } finally {
            executor.shutdown();
        }
    }

}
