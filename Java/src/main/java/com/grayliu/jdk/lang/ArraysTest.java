package main.java.com.grayliu.jdk.lang;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/8/23.
 *
 * 1）Arrays.asList 不接受基本数据类型（int[]，long[]，char[]，这些类型会被认为是一个array对象）
 *
 * 2）asList后再iterator不能调用remove方法（asList的对象是Arrays自定义的没有定义remove方法，而iterator的remove的时候会调用实例对象的remove方法，所以就会报unsupportoperationexception）
 *
 */
public class ArraysTest {

    public static void main(String...args){
        Integer[] arr = new Integer[]{12,3,4,42,12,232};

        List list = Arrays.asList(arr);

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            Object item = iterator.next();
            System.out.println(item);
            iterator.remove();
        }

//        System.out.println(iterator.toString());

    }

}
