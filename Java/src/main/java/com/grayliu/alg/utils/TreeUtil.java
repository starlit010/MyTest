package main.java.com.grayliu.alg.utils;

/**
 * Created by liuhui-ds9 on 2018/2/9.
 */
public class TreeUtil {

    public static void swap(int[] items, int split, int i, int j) {
        int x = items[split + i];
        items[split + i] = items[split + j];
        items[split + j] = x;
    }

    public static boolean hasLeftChild(int[] items, int split, int i) {
        if (split + 2 * i + 1 <= items.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasRightChild(int[] items, int split, int i) {
        if (split + 2 * i + 2 <= items.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int heigh(int size) {
        int heigh = 0;
        while ((size = size >> 1) > 0) {
            heigh++;
        }
        return heigh;
    }

//    public static void main(String...args){
//        System.out.println(heigh(1));
//    }

}
