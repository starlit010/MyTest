package com.grayliu.jdk.concurrent;

import java.util.concurrent.*;

/**
 * Created by liuhui-ds9 on 2018/11/28.
 */
public class FuturTest {

    public static void main(String...args){
        FutureTask ft = new FutureTask(() -> {return 1;});
        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor1 = new ThreadPoolExecutor()
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };
        executor.execute(ft);
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}
