package com.grayliu.autoclawer.http;

import com.grayliu.autoclawer.html.CatPage;
import com.grayliu.autoclawer.html.WatchData;
import com.grayliu.autoclawer.http.enums.DomainEnum;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
public class HttpClawer {

    public void startClawer(){
        DomainEnum[] enums = DomainEnum.values();
        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());
        for(DomainEnum item : enums){
            Map<String, String> urls = URLTemplate.getUrl(item, date);
            urls.entrySet().forEach(entry -> {
                System.out.println(entry.getValue());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clawerData(entry.getValue());
            });
        }
    }

    public void clawerData(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.

        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CatPage catPage = new CatPage();
            WatchData watchData = catPage.ParseHtml(inputStreamReader);
            if(watchData != null){
                System.out.println(watchData.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String...args){

        HttpClawer httpClawer = new HttpClawer();
        httpClawer.startClawer();



    }

}
