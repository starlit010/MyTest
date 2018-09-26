package com.grayliu.operate;

import java.io.IOException;

/**
 * Created by liuhui-ds9 on 2018/7/20.
 */
public class EchoExec implements Runnable{

    @Override
    public void run() {
        try {
//            Runtime.getRuntime().exec("cmd echo hello > D:/test.txt");
            Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
