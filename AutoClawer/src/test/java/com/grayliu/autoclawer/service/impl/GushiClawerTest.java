package com.grayliu.autoclawer.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liuhui-ds9 on 2018/11/22.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GushiClawerTest {

//    @Autowired
    GushiClawer gushiClawer;

//    @Test
    public void testInsert(){
        GushiClawer.Function0 function0 = gushiClawer.new Function0();
        GushiClawer.Function1 function1 = gushiClawer.new Function1();
        GushiClawer.Function2 function2 = gushiClawer.new Function2();

        String line = "<span><a href=\"/shiwenv_9a9463173105.aspx\" target=\"_blank\">qqe</a>(a)</span>";

        function0.andThen(function1).andThen(function2).apply(line);
    }


}
