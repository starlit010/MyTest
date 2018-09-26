package main.java.com.grayliu.alg.sort;

import main.java.com.grayliu.alg.utils.TreeUtil;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/2/8.
 */
public class HeapSort {

    static int[] items = {1,2,8,7,4,44,123,4343,343,1,23};

    /**
     * 堆建大根堆
     *
     */
    public void makeHeap(int split, int head, int tail){
        int heigh = TreeUtil.heigh(tail - head + 1);
        for(int i = heigh ; i >= 0 ; i-- ){
            int start = 1 << i;
            int end = 1 << (i + 1) > tail - head ? tail : 1 << (i + 1);
            for(int j = start - 1; j <= end - 1 ; j++){
                if(j <= tail){
                    compare(split, j);
                }
            }
        }
    }

    /**
     *
     * @param split  偏移地址
     * @param i       相对地址
     */
    public void compare(int split,int i){
        if(TreeUtil.hasLeftChild(items,split,i) && TreeUtil.hasRightChild(items,split, i)){
            if(items[split + 2 * i + 2 ] > items[split + i] && items[split + 2 * i + 2 ] > items[split + 2 * i + 1]){
                TreeUtil.swap(items,split,2 * i + 2, i);
            }else if(items[split + 2 * i + 1 ] > items[split + i] && items[split + 2 * i + 1] >items[split + 2 * i + 2 ] ){
                TreeUtil.swap(items,split,2 * i + 1, i);
            }
        }else if(TreeUtil.hasLeftChild(items,split,i)){
            if(items[split + i] <= items[split + 2 * i + 1]){
                TreeUtil.swap(items,split,2 * i + 1, i);
            }
        }
    }

    /**
     * 对构建完的大根堆进行输出
     */
    public void heapSort(){
        for(int i = 0 ; i < items.length ; i ++){
            if(rebuild(i)){
                System.out.println(items[i]);
            }
        }
    }

    public boolean rebuild(int i){
        if(i == 0){
            return true;
        }else{
            int parent = i / 2;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            if(left > items.length - 1){
                return true;
            }
            if(right <= items.length - 1 && items[left] >= items[right]){
                return true;
            }else{
                TreeUtil.swap(items,0,left,right);
                return rebuild(2 * right + 1);
            }
        }
    }

    public static void main(String...args){
        HeapSort heapSort = new HeapSort();
//        System.out.println(Arrays.toString(heapSort.items));
        //使用构建大根堆的方法排序，效率低下
//        for(int i = 0 ; i < items.length ; i ++){
//            heapSort.makeHeap(i, i, items.length - 1);
//            System.out.println(Arrays.toString(heapSort.items));
//        }
        //先构建堆，然后使用堆输出
        heapSort.makeHeap(0, 0, items.length - 1);
        System.out.println(Arrays.toString(heapSort.items));
        for(int i = 1 ; i < items.length ; i++){
            heapSort.rebuild(i);
            System.out.println(Arrays.toString(heapSort.items));
        }
    }

}
