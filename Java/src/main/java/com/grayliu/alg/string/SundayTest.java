package main.java.com.grayliu.alg.string;

/**
 * Created by liuhui-ds9 on 2018/3/12.
 */
public class SundayTest {

    public static int sunday(char[] strArray,char[] patArray){
        int len = patArray.length;
        int i = 0, j = 0, position = -1;
        for(; i < strArray.length && j < patArray.length ;){
            if(strArray[i] == patArray[j] && j != len - 1){
                i++;
                j++;
            }else if(strArray[i] == patArray[j] && j == len - 1){
                return i - len + 1;
            }else{
                if(j != 0){
                    i = i + 1;
                    if(i > strArray.length){
                        return -1;
                    }else{
                        continue;
                    }
                }else{
                    i = i + len;
                    if(i >= strArray.length){
                        return -1;
                    }else{
                        position = getPosition(strArray[i],patArray);
                        if(position != -1){
                            i = i - position;
                            j = 0;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int getPosition(char c,char[] patArray){
        for(int i = 0 ; i < patArray.length ; i++){
            if(patArray[i] == c){
                return i;
            }
        }
        return -1;
    }

    public static void main(String...args){
        String str = "BBCABCDABABCDABCDABDE";
        String pat = "ABCDABC";
        System.out.println(sunday(str.toCharArray(),pat.toCharArray()));
    }
}
