package main.java.com.grayliu.jdk.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuhui-ds9 on 2018/8/9.
 */
public class PatternTest {

    public static void main(String... args) {

        String pStr = "((?:(?:25[0-5]|2[0-4]\\d|[1-9]\\d|\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[1-9]\\d|\\d))";

        Pattern pattern = Pattern.compile(pStr);

        Matcher matcher = pattern.matcher("255.1.1.1");


        System.out.println(matcher.find());


    }


}
