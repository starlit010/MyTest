package com.grayliu.jdk.jdk8;

import java.util.function.Function;

/**
 * Created by liuhui-ds9 on 2018/8/30.
 *
 * 箭头前是输入，箭头后是输出
 *
 * 连加操作
 */
public class ArrowTest {


    public void test(){

        Function<String,String> f = str -> str + "1";

        Function<String,String> f1 = temp -> temp + "2";

        String result = f.andThen(f1).apply("0");

        System.out.println(result);

    }

    public static void main(String...args){
        new ArrowTest().test();
    }


}
