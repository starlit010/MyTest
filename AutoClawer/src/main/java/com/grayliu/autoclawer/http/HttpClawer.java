package com.grayliu.autoclawer.http;

import com.grayliu.autoclawer.html.GushiPage;
import com.grayliu.autoclawer.html.HtmlDataParse;
import com.grayliu.autoclawer.html.HtmlData;
import com.grayliu.autoclawer.html.TotalPage;
import com.grayliu.autoclawer.http.enums.DomainEnum;
import com.grayliu.autoclawer.http.enums.TotalDomainEnum;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
public class HttpClawer {

    public Map<String, HtmlData> startClawer(String date){
        Map<String, HtmlData> result = new HashMap<String, HtmlData>();
        DomainEnum[] enums = DomainEnum.values();
//        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());
        for(DomainEnum item : enums){
            Map<String, String> urls = URLTemplate.getUrl(item, date);
            urls.entrySet().forEach(entry -> {
                System.out.println(entry.getValue());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HtmlData watchData = clawerData(entry.getValue());
                result.put(entry.getKey(), watchData);
            });
        }
        return result;
    }

    public Map<String, HtmlData> startTotalClawer(String date){
        Map<String, HtmlData> result = new HashMap<String, HtmlData>();
        TotalDomainEnum[] enums = TotalDomainEnum.values();
        for(TotalDomainEnum item : enums){
            Map<String, String> urls = URLTemplate.getTotalUrl(item, date);
            urls.entrySet().forEach(entry -> {
                System.out.println(entry.getValue());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HtmlData watchData = clawerTotalData(entry.getValue());
                result.put(entry.getKey(), watchData);
            });
        }
        return result;
    }

    public String clawerUrl(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.

        HttpGet httpGet = new HttpGet(url);

        InputStreamReader inputStreamReader = null;

        String content = null;
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            inputStreamReader = new InputStreamReader(inputStream);
            GushiPage gushiPage = new GushiPage();
            content = gushiPage.parseHtml(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    public HtmlData clawerData(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.

        HttpGet httpGet = new HttpGet(url);

        HtmlData watchData = null;
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            HtmlDataParse htmlDataParse = new HtmlDataParse();
            watchData = htmlDataParse.ParseHtml(inputStreamReader);

        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return watchData;
    }

    public HtmlData clawerTotalData(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.

        HttpGet httpGet = new HttpGet(url);

        HtmlData watchData = null;
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            TotalPage catPage = new TotalPage();
            watchData = catPage.ParseHtml(inputStreamReader);

        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return watchData;
    }


    public static void main(String...args){

        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());
        HttpClawer httpClawer = new HttpClawer();
        httpClawer.startClawer(date);



    }

}
