package main.java.com.grayliu.alg.search;

/**
 * Created by liuhui-ds9 on 2018/3/16.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int start, int end, int expect) {
        int length = end - start;
        if (length == 0) {
            return -1;
        }
        int index = start + length / 2;
        if (array[index] < expect) {
            return binarySearch(array, index, array.length - 1, expect);
        } else if (array[index] > expect) {
            return binarySearch(array, 0, index, expect);
        } else {
            return index;
        }
    }


    public static void main(String... args) {
        int[] array = {3, 4, 5, 7, 12, 23, 353, 1234};
        System.out.println(binarySearch(array, 0, array.length - 1, 12));
    }

}
