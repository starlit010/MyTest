package com.grayliu.autoclawer.service.impl;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by liuhui-ds9 on 2018/12/7.
 */
@Component
public class ZhihuClawer {


    public void searchQuestion() {
        String str;
        // 创建一个webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        // htmlunit 对css和javascript的支持不好，所以请关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setUseInsecureSSL(false);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        webClient.getOptions().setTimeout(10000);
        // 获取页面
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://www.zhihu.com/question/304722877");

            // 获取页面的TITLE
//            str = page.getTitleText();
//            System.out.println(str);
//            // 获取页面的XML代码
//            str = page.asXml();
//            System.out.println(str);
//            // 获取页面的文本
            str = page.asText();
            System.out.println(str);



            // 关闭webclient
            webClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        ZhihuClawer zhihuClawer = new ZhihuClawer();
        zhihuClawer.searchQuestion();
    }


}
