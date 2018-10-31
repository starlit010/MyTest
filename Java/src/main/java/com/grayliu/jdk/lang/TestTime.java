package com.grayliu.jdk.lang;

import java.text.SimpleDateFormat;

/**
 * Created by liuhui-ds9 on 2018/10/13.
 */
public class TestTime {

    public static void main(String...args){

        String format = "YYYY-MM-dd HH:mm:ss";

        Long current = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        System.out.println(sdf.format(current));

        System.out.println(sdf.format(1539487013838L));

        System.out.println(sdf.format(1539573413838L));

        System.out.println(sdf.format(1539406314000L));



    }


}
