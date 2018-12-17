package com.grayliu.autoclawer;

import com.grayliu.autoclawer.service.impl.EnglishClawer;
import com.grayliu.autoclawer.service.impl.GushiClawer;
import com.grayliu.autoclawer.service.impl.XwlboClawer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"com.grayliu.autoclawer"})
//@SpringBootApplication
public class CommandApplication implements CommandLineRunner {

    @Autowired
    GushiClawer gushiClawer;

    @Autowired
    XwlboClawer xwlboClawer;

    @Autowired
    EnglishClawer englishClawer;

    @Override
    public void run(String... strings) throws Exception {
//        englishClawer.setSearchList(null);
//        englishClawer.clawerHtml();

//        gushi gushi = new gushi();
//        gushi.setAge("asfasfd");
//        gushi.setContent("sfasdfsf");
//        List<gushi> list = new ArrayList<gushi>();
//        list.add(gushi);
//        gushiClawer.insertToDB(list);
//        gushiClawer.clawerFromFiles();

//        List<XwlboClawer.HtmlInfo> htmlInfoList = new ArrayList<XwlboClawer.HtmlInfo>();
//        XwlboClawer.HtmlInfo htmlInfo = new XwlboClawer().new HtmlInfo();
//        htmlInfo.setRealPath("http://xwlbo.com/20211.html");
//        htmlInfo.setDateStr("2018-12-10");
//        htmlInfoList.add(htmlInfo);
//        xwlboClawer.setSearchList(htmlInfoList);
//        xwlboClawer.clawerHtml();
    }

    public static void main(String...args){
        SpringApplication application = new SpringApplication(CommandApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run();
    }

}
