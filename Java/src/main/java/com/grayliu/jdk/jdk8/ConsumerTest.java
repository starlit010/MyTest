package main.java.com.grayliu.jdk.jdk8;

import java.util.function.Consumer;

/**
 * Created by liuhui-ds9 on 2018/8/30.
 *
 * 先构造链再执行链
 *
 * 这个方法的作用主要是定义一个可执行方法
 */
public class ConsumerTest {

    public void test(){

        Consumer<StringBuilder> consumerA = new Consumer<StringBuilder>() {

            @Override
            public void accept(StringBuilder s) {
                s.append(" AConsumer");
            }

        };

        Consumer<StringBuilder> consumerB = new Consumer<StringBuilder>() {

            @Override
            public void accept(StringBuilder s) {
                s.append(" BConsumer");
            }

        };

//        consumerA.accept("hello ");
        Consumer consumerC = consumerA.andThen(consumerB);

        Consumer consumerD = consumerC.andThen(consumerA);

        StringBuilder hello = new StringBuilder("hello");

        consumerD.accept(hello);

        System.out.println(hello);
    }

    public static void main(String...args){
        ConsumerTest consumerTest = new ConsumerTest();
        consumerTest.test();
    }

}
