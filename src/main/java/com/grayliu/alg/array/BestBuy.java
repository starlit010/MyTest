package com.grayliu.alg.array;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/9/5.
 */
public class BestBuy {

    Integer[] array = {7, 1, 5, 3, 6, 4};

    int min = array[0],max = array[0],minIndex = 0,maxIndex = 0;

    public void compute(){
        for(int i = 1; i < array.length ; i++){
            if(maxIndex < minIndex){
                max = 0;
            }
            if(array[i] < min){
                min = array[i];
                minIndex = i;
                continue;
            }
            if(array[i] > max && i > minIndex){
                max = array[i];
                maxIndex = i;
                continue;
            }
        }
        System.out.println("minIndex:"+minIndex+",maxIndex:"+maxIndex+",min:"+min+",max:"+max);
    }

    public static void main(String...args){
        BestBuy bestBuy = new BestBuy();
        bestBuy.compute();
    }
}
