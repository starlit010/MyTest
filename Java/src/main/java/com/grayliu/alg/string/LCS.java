package main.java.com.grayliu.alg.string;

/**
 * Created by liuhui-ds9 on 2018/8/28.
 *
 * longgest common sequence
 *
 * 求最长公共子序列
 *
 * 比较二维数组法和哈希法
 *
 * */
public class LCS {

    //expact blog
    public static String A = "cnblogs";
    public static String B = "belong";

    void solution(){
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();

        StringBuilder maxSeq = new StringBuilder();
        StringBuilder tempSeq = new StringBuilder();

        int tempX = 0,tempY = 0;
        boolean isContinue =false;

        outter:for(int x = 0 ; x < arrayA.length ; x++){

            inner:for(; tempY < arrayB.length ; tempY++){

                if(arrayB[tempY] == arrayA[x]){
                    tempSeq.append(arrayB[tempY]);

                    if(tempY == arrayB.length - 1){
                        tempY = 0;
                    }
                    if(!isContinue){
                        tempX = x;
                        isContinue = true;
                    }
                    if(tempY != arrayB.length - 1){
                        continue outter;
                    }
                }

                if(tempY == arrayB.length - 1){
                    if(tempSeq.length() > maxSeq.length()){
                        maxSeq = tempSeq;
                        tempSeq = new StringBuilder();
                    }
                    if(tempX != 0 && x != arrayA.length - 1){
                        x = tempX;
                    }
                    tempY = 0;
                    isContinue = false;
                    continue outter;
                }
            }
        }

        System.out.println(maxSeq);
    }

    public static void main(String...args){

        LCS lcs = new LCS();
        lcs.solution();

    }



}
