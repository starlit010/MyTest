package main.java.com.grayliu.jdk.lang;

/**
 * Created by liuhui-ds9 on 2018/8/23.
 */
public class SwitchTest {


    public static void main(String... args) {

        String verbose = args[0];

        switch (verbose) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                System.out.println("hello world");
        }


    }


}
