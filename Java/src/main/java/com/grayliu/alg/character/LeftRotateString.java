package com.grayliu.alg.character;

/**
 * Created by liuhui-ds9 on 2018/7/25.
 */
public class LeftRotateString {

    public String LeftRotateString(String str, int n) {
        char[] array = str.toCharArray();
        int len = array.length;
        char temp;

        if (len == 0 || n == 0) {
            return str;
        }
        for (int i = 0; i < n; i++) {
            temp = array[0];
            for (int j = 0; j < len - 1; j++) {
                array[j] = array[j + 1];
            }
            array[len - 1] = temp;
        }
        return new String(array);
    }

}
