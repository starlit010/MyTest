package com.grayliu.jdk.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/8/30.
 *
 * 引入了一个新类 Comsumer
 *
 * 被引用方法需要是静态方法
 *
 */
public class Colon {

    public static void print(Object obj){
        System.out.println(obj.toString());
    }

    public void method(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.forEach(Colon :: print);

        Integer[] array = {1,2,3,4,5,6};
        List arrayList = Arrays.asList(array);
        print(arrayList.size());
        arrayList.forEach(Colon :: print);
    }

    public static void main(String...args){

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.forEach(Colon :: print);

        Integer[] array = {1,2,3,4,5,6};
        List arrayList = Arrays.asList(array);
        print(arrayList.size());
        arrayList.forEach(Colon :: print);

    }
}



