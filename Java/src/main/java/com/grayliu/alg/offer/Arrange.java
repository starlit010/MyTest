package com.grayliu.alg.offer;

/**
 * Created by liuhui-ds9 on 2018/9/7.
 *
 * 1、题目就是一个全排列问题，好像没有什么好的办法，只能多重循环或者递归
 *
 * 2、但是有一个优化的方法就是多线程并发调用
 *
 * 3、遇到这种问题怎么想，首先这是一个排列组合的问题。需要前项和后项，这就是入参，
 *
 * 有入参就能确定子问题，确定子问题然后迭归就可以了
 *
 * 4、递归转非递归
 *
 */
public class Arrange {

    public static void main(String...args){

        String str = "abcd";

        char[] array = str.toCharArray();

        otherArray("", array);

    }

    public static void otherArray(String str, char[] array){
        if(array.length > 1){
            for(char c : array){
                otherArray(str + c, except(c, array));
            }
        }else{
            System.out.println(str + array[0]);
        }
    }

    public static char[] except(char x, char[] array){
        char[] exists = new char[array.length - 1];
        int j = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] != x){
                exists[j] = array[i];
                j++;
            }
        }
        return exists;
    }

}
