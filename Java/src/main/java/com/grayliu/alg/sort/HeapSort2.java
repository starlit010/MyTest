package com.grayliu.alg.sort;

import com.grayliu.alg.utils.TreeUtil;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/2/11.
 *
 * ��Ϊ����Ӷ���ɾ��һ��Ԫ�غ��������Ԫ�ض�Ҫ��ǰ�ƶ������Ի�Ӱ������
 *
 * һ�ַ����ǲ��ϸ��ǶѶ�Ԫ�أ�����ǰ�����������
 *
 * һ���������һλ�滻��Ԫ�أ�Ȼ�������
 *
 *
 */
public class HeapSort2 {

    public void rotate(int[] items,int size,int currentIndex){
        if(hasLeftChild(currentIndex,size) && hasRightChild(currentIndex,size)){
            if(items[2 * currentIndex + 1] > items[2 * currentIndex +2] && items[2* currentIndex + 1] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 1);
                rotate(items, size, 2 * currentIndex + 1);
            }else if(items[2 * currentIndex + 2] > items[2 * currentIndex + 1] && items[2* currentIndex + 2] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 2);
                rotate(items, size, 2 * currentIndex + 2);
            }else{
                rotateUp(items,size,currentIndex/2);
            }
        }else if(hasLeftChild(currentIndex,size)){
            if(items[2* currentIndex + 1] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 1);
                rotateUp(items, size, currentIndex / 2);
            }
        }else{
            rotateUp(items, size, currentIndex / 2);
        }
    }

    public void rotateUp(int[] items,int size,int currentIndex){
        if(currentIndex == 0){
            return;
        }
        if(hasLeftChild(currentIndex,size) && hasRightChild(currentIndex,size)){
            if(items[2 * currentIndex + 1] > items[2 * currentIndex +2] && items[2* currentIndex + 1] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 1);
                rotateUp(items, size, currentIndex/2);
            }else if(items[2 * currentIndex + 2] > items[2 * currentIndex + 1] && items[2* currentIndex + 2] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 2);
                rotateUp(items, size, currentIndex/2);
            }else{
                rotateUp(items,size,currentIndex/2);
            }
        }else if(hasLeftChild(currentIndex,size)){
            if(items[2* currentIndex + 1] > items[currentIndex]){
                swap(items,currentIndex ,2 * currentIndex + 1);
                rotateUp(items,size,currentIndex/2);
            }else{
                rotateUp(items,size,currentIndex/2);
            }
        }
    }

    public void buildHeap(int[] items){
        int heigh = TreeUtil.heigh(items.length);
        for(int x = heigh ; x > 0 ; x-- ){
            int loopFirst = x - 1;
            int loopLast = 2 * x - 1;
            for(int y = loopFirst ; y <= loopLast ; y++){
                if(hasLeftChild(y,items.length) || hasRightChild(y,items.length)){
                    if(items[2*y+1] > items[y] && items[2*y+1] > items[2*y+2]){
                        swap(items,2*y+1,y);
                    }
                    if(items[2*y+2] > items[y] && items[2*y+2] > items[2*y+1]){
                        swap(items,2*y+2,y);
                    }
                }else if(hasLeftChild( y, items.length)){
                    if(items[2*y+1] > items[y]){
                        swap(items,2*y+1,y);
                    }
                }
            }
        }
    }

    private boolean hasLeftChild(int item,int size){
        if(item * 2 + 1 < size){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasRightChild(int item,int size){
        if(item * 2 + 2 < size){
            return true;
        }else{
            return false;
        }
    }

    private void swap(int items[],int a,int b){
        int temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

    public static void main(String...args){
        int items[] = {1,2,34,54,5,6,9};
        HeapSort2 heapSort2 = new HeapSort2();
        heapSort2.buildHeap(items);

        for(int i = 0 ; i < items.length; i++) {
            heapSort2.swap(items,0,items.length - 1 - i);
            heapSort2.rotate(items,items.length - 1 - i,0);
        }

        System.out.println(Arrays.toString(items));
    }

}
