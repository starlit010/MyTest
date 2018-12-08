package com.grayliu.jdk.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liuhui-ds9 on 2018/11/28.
 */
public class ReflactTest {

    private static String hello = null;

    public String world ;

    public String getMessage(){
        return hello;
    }

    public static void main(String...args){

        try {
            Class reflactClaz = ReflactTest.class;
            ReflactTest reflactTest = (ReflactTest)reflactClaz.newInstance();
            Field[] fields = reflactClaz.getDeclaredFields();
            Method[] methods = reflactClaz.getDeclaredMethods();

            Field helloField = reflactClaz.getDeclaredField("hello");
            helloField.setAccessible(true);
            helloField.set(reflactTest,"hello1");
//            hello.setAccessible(true);
//            hello.set(String.class, "hello");
//            System.out.println(hello.toString());
            System.out.println(reflactTest.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

}
