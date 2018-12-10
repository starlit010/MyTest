package com.grayliu.alg.sort;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/2/26.
 */
public class QuickSort {

    public static void main(String... args) {
        int[] array1 = {1, 23, 4, 35, 1, 23, 3, 4};
        quickSortOne(array1, 0, array1.length - 1);
        printArray(array1);

        int[] array2 = {1, 23, 4, 35, 1, 23, 3, 4};
        quickSortTwo(array2, 0, array2.length - 1);
        printArray(array2);

        int[] array3 = {1, 23, 4, 35, 1, 23, 3, 4};
        quickSortThree(array3, 0, array3.length - 1);
        printArray(array3);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     */
    public static void quickSortOne(int[] array, int start, int end) {
        if (array.length == 0 || start == end) {
            return;
        }
        int front = start + 1, back = end;
        while (front != back) {
            for (; back > front; back--) {
                if (array[back] <= array[start]) {
                    break;
                }
            }
            for (; front < back; front++) {
                if (array[front] > array[start]) {
                    break;
                }
            }
            int temp = array[front];
            array[front] = array[back];
            array[back] = temp;
        }
        if (array[start] > array[front]) {
            int temp = array[start];
            array[start] = array[front];
            array[front] = temp;
        }
        quickSortOne(array, start + 1, front);
        quickSortOne(array, front, end);
    }


    public static void quickSortTwo(int[] array, int start, int end) {

        if (array.length == 0 || start >= end || start < 0 || end < 0) {
            return;
        }

        int from = start;
        int to = end;
        int middle = array[(to + from) / 2];

        while (from != to) {

            while (array[from] < middle && from < to) {
                from++;
            }
            while (array[to] > middle && to > from) {
                to--;
            }

            if (array[to] == array[from] && to != from && from < end) {
                from++;
            } else {
                int temp = array[from];
                array[from] = array[to];
                array[to] = temp;
            }


        }
//            if(array[from] >= middle && start < from - 1){
        quickSortTwo(array, start, from - 1);
        quickSortTwo(array, from + 1, end);
//            }
    }

    public static void quickSortThree(int[] array, int front, int back) {
        if (array == null || front < 0 || front >= array.length || front >= back || back <= front || back >= array.length) {
            return;
        }

        int middle = array[front + (back - front) / 2];
        int tempFront = front;
        int tempBack = back;

        while (tempFront < tempBack) {

            while (tempFront < tempBack && array[tempFront] < middle) {
                tempFront++;
            }

            while (tempBack > tempFront && array[tempBack] >= middle) {
                tempBack--;
            }

            int temp = array[tempFront];
            array[tempFront] = array[tempBack];
            array[tempBack] = temp;

        }

        quickSortThree(array, front, tempFront - 1);
        quickSortThree(array, tempFront + 1, back);


    }

}
