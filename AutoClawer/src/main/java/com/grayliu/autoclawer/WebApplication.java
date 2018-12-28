package com.grayliu.autoclawer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
//@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"com.grayliu.autoclawer"})
public class WebApplication {

    public static void main(String...args){
        SpringApplication.run(WebApplication.class, args);
    }
}
