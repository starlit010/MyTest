package main.java.com.grayliu.jdk.lang;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/6/21.
 */
public class SortLeft {

    int[] array = {1, 2, 2, 2, 3, 4, 5, 6};

    public void sortLeft() {
        int temp = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] != array[i - 1] && temp != 0) {
                int temp1 = array[temp];
                array[temp] = array[i];
                array[i] = temp1;
                temp++;
            } else if (array[i] == array[i - 1] && array[i] != array[temp]) {
                temp = i;
            }

        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String... args) {
        SortLeft sortLeft = new SortLeft();
        sortLeft.sortLeft();
    }

}
