package com.grayliu.alg.string;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/12/17.
 */
public class KMP {

    int[] preArray = null;

    private int[] makePreArray(char[] pattern){
        int[] rtnArray = new int[pattern.length];
        Arrays.fill(rtnArray, 0);
        int i = 0 , j = 1 , k = 0;
        for(int x = 1 ; x < pattern.length ; x++){
            if(pattern[i] == pattern[j]){
                k++;
                rtnArray[x] = k;
                i++;
                j++;
            }else{
                rtnArray[x] = k;
                k = 0;
            }
        }
        return rtnArray;
    }

    private int getNext(int index){
        return preArray[index];
    }

    public int kmpSearch(char[] input, char[] pattern){

        preArray = makePreArray(pattern);

        int i = 0,j = 0;
        while(j != pattern.length - 1){
            if(input[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j = getNext(j);
                }
            }
        }
        return i - j;
    }

    public static void main(String...args){
        KMP kmp = new KMP();
        String inputStr = "abcddafad";
        String patternStr = "dda";
        int index = kmp.kmpSearch(inputStr.toCharArray(),patternStr.toCharArray());
        System.out.print(index);
    }

}
