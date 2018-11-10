package com.grayliu.jdk.lang;

/**
 * Created by liuhui-ds9 on 2018/11/5.
 */
public class DoubleTest {


    public void String2Double(String str){
        double number = Double.parseDouble(str);
        Double numberD = Double.valueOf(str);
        System.out.println(number);
        System.out.println(numberD.intValue());
    }

    public static void main(String...args){
        DoubleTest doubleTest = new DoubleTest();
        doubleTest.String2Double("1.00000");
    }



}
