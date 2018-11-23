package com.grayliu.autoclawer;

import com.grayliu.autoclawer.dao.GushiDao;
import com.grayliu.autoclawer.entity.Gushi;
import com.grayliu.autoclawer.service.impl.GushiClawer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.grayliu.autoclawer"})
@SpringBootApplication
public class CommandApplication implements CommandLineRunner {

    @Autowired
    GushiClawer gushiClawer;

    @Override
    public void run(String... strings) throws Exception {
//        Gushi gushi = new Gushi();
//        gushi.setAge("asfasfd");
//        gushi.setContent("sfasdfsf");
//        List<Gushi> list = new ArrayList<Gushi>();
//        list.add(gushi);
//        gushiClawer.insertToDB(list);

//        gushiClawer.clawerFromFiles();
    }

    public static void main(String...args){
        SpringApplication application = new SpringApplication(CommandApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run();
    }

}
