package com.grayliu.myvesta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuhui-ds9 on 2018/4/11.
 */
@Controller
public class HelloWorld {

    @RequestMapping(value = "/")
    @ResponseBody
    public String helloWorld(){
        return "hello, world";
    }


}
