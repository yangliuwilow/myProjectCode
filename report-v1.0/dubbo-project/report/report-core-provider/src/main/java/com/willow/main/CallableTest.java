package com.willow.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    public static void main(String[] args)throws ExecutionException,InterruptedException{
        ExecutorService pool=Executors.newFixedThreadPool(200);
        for(int i=0;i<100;i++){


        Callable c1=new MyCallable("A"+i);
        Callable c2=new MyCallable("B"+i);
        Future f1=pool.submit(c1);
        Future f2=pool.submit(c2);
        System.out.println(">>>"+f1.get().toString());
        System.out.println(">>>"+f2.get().toString());
        }
        pool.shutdown();
    }
}
class MyCallable implements Callable{
    private String oid;
    MyCallable(String oid){
        this.oid=oid;
    }
    public Object call()throws Exception{
        Thread.sleep(1000);
        return oid;
    }
    
}