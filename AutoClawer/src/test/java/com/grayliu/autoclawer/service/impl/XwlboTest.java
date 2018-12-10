package com.grayliu.autoclawer.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XwlboTest {

    @Autowired
    XwlboClawer xwlboClawer;

    @Test
    public void testClawer(){
        xwlboClawer.clawerHtml();
    }

}
