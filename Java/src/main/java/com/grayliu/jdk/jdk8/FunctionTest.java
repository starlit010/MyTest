package main.java.com.grayliu.jdk.jdk8;

import java.util.function.Function;

/**
 * Created by liuhui-ds9 on 2018/8/30.
 *
 * 调用function的默认构造方法apply，注意function的范型类型定义
 *
 * 这个接口的作用主要是定义一个对象的转换
 */
public class FunctionTest {

    public void test(){

        Function<String,String> function = new Function(){

            @Override
            public Object apply(Object o) {
                return null;
            }
        };

    }


}
