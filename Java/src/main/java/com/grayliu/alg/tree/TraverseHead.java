package com.grayliu.alg.tree;

/**
 * Created by liuhui-ds9 on 2018/2/8.
 */
public class TraverseHead {

    int[] items = {1,2,3,45,4,4,23,23,45,7};

    /**
     *
     * @param i
     * @return
     *
     *      1
     *     2 3
     *   45 4 4 23
     *  23 45 7
     *
     *
     */
    public boolean hasLeftChild(int i){
        if(items.length <= 1){
            return false;
        }
        if( 2 * i > items.length){
            return false;
        }else{
            return true;
        }
    }

    public boolean hasRightChild(int i){
        if(items.length <= 1){
            return false;
        }
        if( 2 * i + 1 > items.length){
            return false;
        }else{
            return true;
        }
    }

    public void printParent(int i){
        if(items.length >= i){
            System.out.println(items[ i - 1 ]);
        }
    }

    public void traverseHead(int i){
//        for(int i = 1 ; i <= items.length ; i++){
        if(items.length >= i){
            printParent(i);
        }else{
            return;
        }
        if(hasLeftChild(i)){
            traverseHead( 2 * i );
        }
        if(hasRightChild(i)){
            traverseHead( 2 * i + 1);
        }
//        }
    }

    public static void main(String...args){
        TraverseHead traverseHead = new TraverseHead();
        traverseHead.traverseHead(1);
    }

}
