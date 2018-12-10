package com.grayliu.autoclawer.util;

import com.grayliu.autoclawer.entity.fileSystem.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
public class HttpClientUtil {

    public static Document httpGetDocument(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF8");
            return parseHtml(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static FileSystem httpGetFile(String urlStr){
        if(StringUtils.isEmpty(urlStr)){
           return null;
        }
        FileSystem fileSystem = new FileSystem();
        try {
            URL url = new URL(urlStr);
            String location = url.getHost();
            String realPath = url.toString();
            String relativePath = url.getPath();
            fileSystem.setRealPath(realPath);
            fileSystem.setLocation(location);
            fileSystem.setRelativePath(relativePath);
            //封装byte数组
            CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
            HttpGet httpGet = new HttpGet(urlStr);
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int i = 0 ;
            while( ( i = inputStream.read(buffer) ) != -1){
                byteArrayOutputStream.write(buffer,0,i);
            }
            inputStream.close();
            byteArrayOutputStream.close();

            byte[] result = byteArrayOutputStream.toByteArray();
            fileSystem.setContent(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSystem;
    }

    private static Document parseHtml(Reader reader) {
        Document doc = null;
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            doc = Jsoup.parse(sb.toString());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return doc;
    }


}
