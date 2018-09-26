package com.grayliu.operate;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Created by liuhui-ds9 on 2018/7/20.
 */
public class CalcExecTest {

    Executor executor;

    @Before
    public void init(){
        executor = new Executor();
    }

    @Test
    public void testExe() throws IOException, InterruptedException {
        for(int i = 0 ; i < 20 ; i++){
            Future future = executor.execut(new EchoExec());
            Thread.currentThread().sleep(1000);
        }

    }

}
