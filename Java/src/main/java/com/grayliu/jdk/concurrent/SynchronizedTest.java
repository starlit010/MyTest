package main.java.com.grayliu.jdk.concurrent;

/**
 * Created by liuhui-ds9 on 2018/3/6.
 */
public class SynchronizedTest {
    
    int b = 100;

    class Inner implements Runnable {
        SynchronizedTest synchronizedTest = null;

        Inner(SynchronizedTest synchronizedTest)throws InterruptedException{
            this.synchronizedTest = synchronizedTest;
        }

        @Override
        public void run() {
            try{
                synchronizedTest.m1();
//                System.out.println("b=" + synchronizedTest.b);
            }catch(Exception e){

            }
        }
    }
    
    public synchronized void m1() throws InterruptedException{
        b = 1000;
//        Thread.sleep(250);
        System.out.println("b=" + b);
    }

    public synchronized void m2() throws InterruptedException{
//        Thread.sleep(500);
        b = 2000;
    }

    public static void main(String...args)throws InterruptedException{
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Inner inner = new SynchronizedTest().new Inner(synchronizedTest);
        Thread t = new Thread(inner);
        t.start();
        //Thread.sleep(1000);
        synchronizedTest.m2();
        System.out.println("main b=" + synchronizedTest.b);
    }

    
}
