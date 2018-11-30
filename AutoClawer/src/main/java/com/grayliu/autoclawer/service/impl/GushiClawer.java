package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.GushiDao;
import com.grayliu.autoclawer.entity.gushi.Gushi;
import com.grayliu.autoclawer.html.gushi.GushiPage;
import com.grayliu.autoclawer.html.monitor.HtmlData;
import com.grayliu.autoclawer.html.monitor.HttpClawer;
import com.grayliu.autoclawer.service.ClawerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 *
 */
@Service
public class GushiClawer extends ClawerInterface {

    @Autowired
    GushiDao gushiDao;

    String categroy = null;

    HttpClawer httpClawer = new HttpClawer();

    GushiPage gushiPage = new GushiPage();

    public void insertToDB(List<Gushi> gushi) {
        gushiDao.insertList(gushi);
    }

    public List<Gushi> findObject(HtmlData htmlData) {
        return null;
    }

    @Override
    public void clawerHtml(){

//        String filePath = url.getFile();
//        File file = new File(filePath);
        try {
            ClassLoader classLoader = GushiClawer.class.getClassLoader();
            URL url = classLoader.getResource("others/唐诗300首.txt");
            InputStreamReader fr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(fr);

            Function0 function0 = new Function0();
            Function1 function1 = new Function1();
            Function2 function2 = new Function2();
//            function1.andThen(function2);

            String line = br.readLine();
            while(line != null){
                function0.andThen(function1).andThen(function2).apply(line);
//                gushi gushi = function1.apply(line);
//                function1.andThen(function2);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clawerFromWeb(){

    }


    /**
     * 编码过滤
     */
    class Function0 implements Function<String, String>{
        @Override
        public String apply(String s) {
            if(s != null){
                try {
                    String decode = new String(s.getBytes("UTF8"),"UTF8");
                    System.out.println(decode);
                    return decode;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    /**
     * 提取链接
     */
    class Function1 implements Function<String, Gushi>{
        @Override
        public Gushi apply(String s) {
            Gushi gushi = new Gushi();
            if(s.startsWith("<div")){
                String[] str1 = s.split("[()<>]");
                categroy = str1[4];
                return null;
            }else if(s.startsWith("<span")){
                String[] str1 = s.split("[\"()<>]");
                String url = str1[4];
                String title = str1[8];
                String author = str1[11];
                gushi.setAge("唐诗");
                gushi.setAuthor(author);
                gushi.setTitle(title);
                gushi.setCategory(categroy);
                gushi.setCreateTime(new Date(System.currentTimeMillis()));
                gushi.setNewTime(new Timestamp(System.currentTimeMillis()));
                String href = "http://so.gushiwen.org" + url;
                String content = httpClawer.clawerUrl(href);
//                gushi.setContent(content);
            }
            System.out.println(gushi);
            return gushi;
        }
    }

    /**
     * 写入数据库
     */
    class Function2 implements Function<Gushi, String>{
        @Override
        public String apply(Gushi gushi) {
            if(gushi!=null){
//                System.out.println("insert into db " + gushi);
                gushiDao.insert(gushi);
            }
            return null;
        }
    }

//    public static void main(String...args){
//        GushiClawer gushiClawer = new GushiClawer();
//        gushiClawer.clawerFromFiles();
//    }

}
