package com.grayliu.operate.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuhui-ds9 on 2018/7/24.
 */

@Controller
public class TestCatController {

    double payment = 0;

    @RequestMapping(value="/hello")
    public void hello(HttpServletRequest request,HttpServletResponse response){

        //自定义埋点，也可以通过全局过滤器埋点
//        Transaction t = Cat.newTransaction("URL", "hello");
//        try {
//            Cat.logEvent("URL.Method", "/hello");
//            Cat.logMetricForCount("PayCount");
//            Cat.logMetricForSum("payMent", payment);
//
//            t.setStatus(Transaction.SUCCESS);
//        }catch(Exception e){
////            t.setStatus(e);
//        }finally{
//            t.complete();
//        }

        try {
            response.getWriter().print("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
