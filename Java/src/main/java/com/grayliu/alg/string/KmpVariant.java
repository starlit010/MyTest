package main.java.com.grayliu.alg.string;

/**
 * Created by liuhui-ds9 on 2018/3/9.
 */
public class KmpVariant {

    public static int kmpVariant(char[] strArray,char[] patArray){
        outer:for(int i = 0 ; i < strArray.length ; i++){
            int temp = i;
            inner:for(int j = 0 ; j < patArray.length ; j++){
                if(strArray[temp] == patArray[j] && j < patArray.length -1){
                    temp++;
                }else if(strArray[temp] == patArray[j] && j == patArray.length -1){
                    return i;
                }else{
                    continue outer;
                }
            }
        }
        return -1;
    }

    public static void main(String...args){
        String value = "BBCABCDABABCDABCDABDE";
        String pattern = "ABCDABD";
        System.out.println(kmpVariant(value.toCharArray(), pattern.toCharArray()));
    }

}
