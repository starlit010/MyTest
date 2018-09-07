package com.grayliu.alg.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/9/7.
 *
 * 从一个数组中找到第K大的数
 *
 */
public class FindKTop {

    /**
     *
     * 有个数组一直保存前K大的数
     *
     * 也可以用链表，但是看超来比较复杂，边界条件太多，还能怎么化简能看超来简洁点
     *
     *
     * @param k
     */
    static int findKndTop(int k, int[] array){
        int kSubstractOne = 0;

        List<Integer> kTop = new LinkedList<Integer>();

        for(int i : array){

            if(i > kSubstractOne){

                insert(i, kTop);

                 kSubstractOne = kTop.get(kTop.size() - 1);

            }

        }

        return kTop.get(k - 1);

    }

    static void insert(int i, List<Integer> kTop){
        if (kTop.size() == 0){
            kTop.add(i);
            return;
        }

        if(kTop.size() == 1){
            if(i > kTop.get(0)){
                kTop.add(kTop.get(0));
                kTop.set(0, i);
            }
            return;
        }

        if(kTop.size() > 1){
            kTop.add(kTop.get(kTop.size() - 1));
//            kTop.set(kTop.size() - 2, i);
        }
        for(int x = kTop.size() - 2 ; x >= 0 ; x--){
            if(i > kTop.get(x)){
                if(x == 0){
                    kTop.set(0, i);
                }else{
                    kTop.set(x, kTop.get(x - 1));
                }
            }else{
                kTop.set(x, i);
                break;
            }
        }
    }

    static int[] array = {1,2,3,4,3,34,3,4,34,3,2,34,23,42,34,24233,34391};

    public static void main(String...args){

        System.out.println(findKndTop(3, array));

    }

}
