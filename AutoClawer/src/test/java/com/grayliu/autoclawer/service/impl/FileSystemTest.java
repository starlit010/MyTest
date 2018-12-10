package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.entity.fileSystem.FileSystem;
import com.grayliu.autoclawer.util.HttpClientUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.URL;

/**
 * Created by liuhui-ds9 on 2018/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSystemTest {

    @Autowired
    FileSystemDao fileSystemDao;

    @Test
    public void testInsert(){
        FileSystem fileSystem = buildFileSystem2();
//        fileSystemDao.insert(fileSystem);
    }

//    @Test
    public void testSelect() {
        FileSystem result = fileSystemDao.queryById(11);
        byte[] bytes = result.getContent();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/query.js");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileSystem buildFileSystem1(){
        FileSystem fileSystem = new FileSystem();
        try {
            String filePath = "D:/个人文档/图片/1519628069909.jpg";
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            fileSystem.setLocation("localhost");
            fileSystem.setRealPath("localhost/123");
            fileSystem.setRelativePath("helloworld");
            fileSystem.setContentType("application/x-jpg");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = fileInputStream.read(buffer);
            while(length > 0){
                byteArrayOutputStream.write(buffer);
                length = fileInputStream.read(buffer);
            }
            byte[] result = byteArrayOutputStream.toByteArray();
            fileSystem.setContent(result);

            fileInputStream.close();
            byteArrayOutputStream.close();

//            fileSystemDao.insert(fileSystem);
//            bufferedReader.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSystem;
    }

    public FileSystem buildFileSystem2(){
        String filePath = "http://tool.oschina.net/js/jquery/jquery-1.7.2.js";
        FileSystem fileSystem = HttpClientUtil.httpGetFile(filePath);
        fileSystem.setLocation("jquery");
        fileSystem.setRealPath("jquery");
        fileSystem.setRelativePath("jquery");
        fileSystem.setTitle("jquery.js");
        fileSystem.setContentType("application/x-javascript");


        try {
            URL url = new URL(filePath);
//            String location = url.getHost();
//            String realPath = url.toString();
//            String relativePath = url.getPath();
//            fileSystem.setRealPath(realPath);
//            fileSystem.setLocation(location);
//            fileSystem.setRelativePath(relativePath);
            //封装byte数组
            CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
            HttpGet httpGet = new HttpGet(filePath);
            CloseableHttpResponse response = httpCilent.execute(httpGet);

            byte[] bytes = new byte[1024];
            InputStream inputStream = response.getEntity().getContent();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int i = inputStream.read(bytes);
            while((i= inputStream.read(bytes)) != -1){
                bos.write(bytes,0,i);
            }

            inputStream.close();

            fileSystem.setContent(bos.toByteArray());
//            bos.flush();

//            String str = bos.toString();
//            System.out.println(str);

//            inputStream.close();
//
//            byte[] bytes1 = bos.toByteArray();
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes1);
//            InputStreamReader osw = new InputStreamReader(byteArrayInputStream);
//
//            BufferedReader bufferedReader = new BufferedReader(osw);
//
//            String line = bufferedReader.readLine();
//            while(line != null){
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//
//            bufferedReader.close();

//            InputStreamReader isr = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(isr);
//
//            String line = bufferedReader.readLine();
//
//            while(line != null){
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//
//            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            fileSystemDao.insert(fileSystem);
//            bufferedReader.
        return fileSystem;
    }

    public static void main(String...args){
        FileSystemTest fileSystemTest = new FileSystemTest();
        fileSystemTest.testInsert();
    }


}
