package com.grayliu.operate;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuhui-ds9 on 2018/7/20.
 */
public class Executor {

    ThreadPoolExecutor threadPoolExecutor;

    public	Executor(){
        synchronized (this){
            if(threadPoolExecutor == null){
                threadPoolExecutor = new ThreadPoolExecutor(10,10,100, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));
            }
        }
    }

    public Future execut(Runnable runnable){
        return threadPoolExecutor.submit(runnable);
    }

    public void finalizer(){
        if(threadPoolExecutor != null){
            threadPoolExecutor.shutdown();
        }
    }

}
