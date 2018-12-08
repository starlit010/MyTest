package com.grayliu.autoclawer.service.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuhui-ds9 on 2018/12/5.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({XwlboTest.class,FileSystemTest.class})
public class JunitTestSuit {
}
