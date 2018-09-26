package main.java.com.grayliu.jdk.concurrent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by liuhui-ds9 on 2018/3/7.
 */
public class ConcurrentModifierTest {

    public static void main(String...args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Integer item = (Integer) iterator.next();
            if(item == 2){
//                list.remove(item);
                iterator.remove();
            }
        }
    }

}

