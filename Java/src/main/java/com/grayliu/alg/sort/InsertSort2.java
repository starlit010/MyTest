package main.java.com.grayliu.alg.sort;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/8/26.
 * <p>
 * 插入排序，从后往前
 */
public class InsertSort2 {

    public static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int j = i;

            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }

        }
    }


    public static void main(String... args) {

        int[] array = new int[]{1, 2, 3, 5, 3, 3, 43, 41, 23, 3};

        sort(array);

        System.out.println(Arrays.toString(array));

    }


}
