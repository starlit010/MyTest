package com.grayliu.alg.sort;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/3/13.
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int flag = array[i];
            boolean swap = false;
            for (int j = 0; j <= i; j++) {
                if (swap) {
                    int temp = array[j];
                    array[j] = flag;
                    flag = temp;
                } else if (flag < array[j]) {
                    int temp = array[j];
                    array[j] = flag;
                    flag = temp;
                    swap = true;
                }

            }
        }
        printArray(array);
    }

    public static int[] insertSortTwo(int[] array) {
        int length = array.length;
        boolean swap = false;
        int temp = 0;

        for (int i = 1; i < length; i++) {
            swap = false;
            for (int j = 0; j <= i; j++) {
                if (swap) {
                    int nextTemp = array[j];
                    array[j] = temp;
                    temp = nextTemp;
                } else {
                    if (array[i] <= array[j]) {
                        temp = array[j];
                        array[j] = array[i];
                        swap = true;
                    }
                }

            }
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String... args) {
        int[] arr = {1, 8, 9, 2, 3, 5, 7};
        insertSort(arr);

        int[] arr1 = {1, 8, 9, 2, 3, 5, 7};
        printArray(insertSortTwo(arr1));
    }
}
