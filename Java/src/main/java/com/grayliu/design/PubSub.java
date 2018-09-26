package main.java.com.grayliu.design;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * Created by liuhui-ds9 on 2018/9/5.
 */
public class PubSub extends Thread{

    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public void pub(String str){
        queue.add(str);
    }

    public void sub(){
        for(;queue.iterator().hasNext();){
            String message = queue.iterator().next();
            queue.remove();
            System.out.println(message);
        }
    }

    @Override
    public void run(){
        while(true){
            try {
                sleep(20000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String...args){
        PubSub pubsub = new PubSub();
        pubsub.start();
        PubThread pub = new PubThread(pubsub);
        SubThread sub = new SubThread(pubsub);
        pub.start();
        sub.start();
    }

}

class PubThread extends Thread{

    PubSub pubsub = null;

    PubThread(PubSub pubsub){
        this.pubsub = pubsub;
    }

    @Override
    public void run(){
        IntStream.range(1,100).forEach((item) -> {
            try {
                sleep(100L);
                pubsub.pub(String.valueOf(item));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class SubThread extends Thread {

    PubSub pubsub = null;

    SubThread(PubSub pubsub){
        this.pubsub = pubsub;
    }

    @Override
    public void run(){
        while(true){
            try {
                sleep(1000L);
                pubsub.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}