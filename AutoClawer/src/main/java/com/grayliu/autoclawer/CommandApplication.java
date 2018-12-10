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

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.grayliu.autoclawer"})
@SpringBootApplication
public class CommandApplication implements CommandLineRunner {

    @Autowired
    GushiClawer gushiClawer;

    @Autowired
    XwlboClawer xwlboClawer;

    @Autowired
    EnglishClawer englishClawer;

    @Override
    public void run(String... strings) throws Exception {
        englishClawer.setSearchList(null);
        englishClawer.clawerHtml();

//        gushi gushi = new gushi();
//        gushi.setAge("asfasfd");
//        gushi.setContent("sfasdfsf");
//        List<gushi> list = new ArrayList<gushi>();
//        list.add(gushi);
//        gushiClawer.insertToDB(list);
//        gushiClawer.clawerFromFiles();
//        xwlboClawer.clawerHtml();
    }

    public static void main(String...args){
        SpringApplication application = new SpringApplication(CommandApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run();
    }

}
