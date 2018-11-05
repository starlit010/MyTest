package com.grayliu.alg.string;

/**
 * Created by liuhui-ds9 on 2018/8/28.
 *
 * longest increase sequence
 *
 * 求最长连续子字符串
 *
 * 只要不连续就保存，进行下一次比较
 *
 * 也有叫DP的
 */
public class LIS {

    //expact lo
    static String A = "cnblogs";
    static String B = "belong";

    char[] arrayA = A.toCharArray();
    char[] arrayB = B.toCharArray();

    StringBuilder tempSeq = new StringBuilder();
    StringBuilder maxSeq = new StringBuilder();

    public void solution(){

        boolean isContinue =false;

        int i = 0, j = 0;
        int tempI = 0,tempJ = 0;

        outter: for(; i < arrayA.length ; i++){

            inner: for(; j < arrayB.length ; j++){

                if(arrayA[i] == arrayB[j]){
                    tempSeq.append(arrayB[j]);
                    if(!isContinue){
                        tempI = i;
                        tempJ = j;
                        isContinue = true;
                        j++;
                    }
                    if(j == arrayB.length - 1){
                        if(tempSeq.length() > maxSeq.length()){
                            maxSeq = tempSeq;
                            tempSeq = new StringBuilder();
                        }
                        if(tempI > 0){
                            i = tempI;
                            j = tempJ;
                            tempI = 0;
                            tempJ = 0;
                        }
                        isContinue = false;
                    }
                    continue outter;
                }else{
                    if(isContinue){
                        if(tempSeq.length() > maxSeq.length()){
                            maxSeq = tempSeq;
                        }
                        if(tempI > 0){
                            i = tempI;
                            tempI = 0;
                            tempJ = 0;
                        }
                        tempSeq = new StringBuilder();

                    }else if(j == arrayB.length - 1){
                        if(tempI > 0){
                            i = tempI;
                            tempI = 0;
                            tempJ = 0;
                        }
                    }
                    j = 0;
                    isContinue = false;
                    continue outter;
                }
            }

        }

        System.out.println(maxSeq);
    }

    void solutionII(){

        int i = 0 ,j = 0;
        int tempI = 0 , tempJ = 0;
        boolean isContinue = false;

        while(true){

            if( i >= arrayA.length || j >= arrayB.length){
                break;
            }

            if(arrayA[i] == arrayB[j]){
                if(!isContinue){
                    isContinue = true;
                    tempI = i;
                }
                tempSeq.append(arrayB[j]);
                i++;
                j++;
            }else{
                if(isContinue){
                    if(tempSeq.length() > maxSeq.length()){
                        maxSeq = tempSeq;
                    }
                    tempSeq = new StringBuilder();
                    i = tempI + 1;
                    j = 0;
                    isContinue = false;
                }else{
                    if(j == arrayB.length - 1){
                        i = tempI + 1;
                        j = 0;
                        isContinue = false;
                    }else{
                        j++;
                    }
                }
            }

        }

        System.out.println(maxSeq);


    }

    public static void main(String...args){
        LIS lis = new LIS();
        lis.solutionII();
    }

}
