package com.grayliu.alg.array;

/**
 * Created by liuhui-ds9 on 2018/7/25.
 */
public class FindInTwoDimensions {


    public boolean Find(int target, int [][] array) {
        if(array.length == 0){
            return false;
        }
        int y = array.length - 1;
        int x = array[0].length - 1;
        if(x < 0){
            return false;
        }
        if(target > array[y][x]){
            return false;
        }
        outer:for(int m = 0 ; m <= y ; m++){
            inner:for(int n = x ; n >= 0 ; n--){
                if(target > array[m][n]){
                    continue outer;
                }else if(target == array[m][n]){
                    return true;
                }else{
                    continue inner;
                }
            }
        }
        return false;
    }


    public static void main(String...args){
        //16,[[]]
        //7,[[1,2,3,4],[7,8,9,10]]
    }

}
