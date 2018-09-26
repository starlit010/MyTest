package main.java.com.grayliu.alg.sort;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/2/28.
 */
public class PopSort {

    public static void main(String...args){
        int[] array = {2,3,23,76,123,90,5,4,5,34};

        PopSortOne popSortOne = new PopSort.PopSortOne();
        popSortOne.sort(array);

        System.out.println(Arrays.toString(array));

        int[] array1 = {2,3,23,76,123,90,5,4,5,34};

        PopSortTwo popSortTwo = new PopSort.PopSortTwo();
        System.out.println(Arrays.toString(popSortTwo.sort(array1)));
    }

    static class PopSortOne{
        public void sort(int[] array){
            int length = array.length;
            for(int i = 0 ; i < length - 1; i++){
                for(int j = 2 ; j < length - i ; j ++){
                    if(array[j - 1] < array[j - 2]){
                        int temp = array[j - 1];
                        array[j - 1] = array[j -2];
                        array[j - 2] = temp;
                    }
                }
            }
        }
    }

    static class PopSortTwo{

        public int[] sort(int[] array){
            int length = array.length;

            for(int i = 0 ; i < length ; i++){
                for(int j = i + 1 ; j < length ; j++){
                    if(array[i] > array[j]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }

            return array;
        }

    }

}
