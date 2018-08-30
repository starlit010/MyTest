package com.grayliu.jdk.jdk8;

import java.util.function.Function;

/**
 * Created by liuhui-ds9 on 2018/8/30.
 *
 * 箭头前是输入，箭头后是输出
 */
public class ArrowTest {


    public void test(){

        Function<String,String> f = str -> new String("1234");

    }


}
