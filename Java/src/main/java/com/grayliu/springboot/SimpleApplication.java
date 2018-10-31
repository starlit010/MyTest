package com.grayliu.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by liuhui-ds9 on 2018/9/20.
 */
@SpringBootApplication
public class SimpleApplication implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("hello simpleapplication");
        BufferedReader commandIn = new BufferedReader(new InputStreamReader(System.in));
        String readLine = null;
        while(true){
            Thread.sleep(100);
            if((readLine = commandIn.readLine()) != null){
                System.out.println(readLine);
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }
}
