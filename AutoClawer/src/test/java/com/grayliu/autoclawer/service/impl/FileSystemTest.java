package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.entity.xwlbo.FileSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

/**
 * Created by liuhui-ds9 on 2018/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileSystemTest {

    @Autowired
    FileSystemDao fileSystemDao;

    @Test
    public void testInsert(){
        FileSystem fileSystem = buildFileSystem();
        fileSystemDao.insert(fileSystem);
    }

    @Test
    public void testSelect() {
        FileSystem result = fileSystemDao.queryById(3);
        byte[] bytes = result.getContent();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/321.jpg");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileSystem buildFileSystem(){
        FileSystem fileSystem = new FileSystem();
        try {
            String filePath = "D:/个人文档/图片/1519628069909.jpg";
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            fileSystem.setLocation("localhost");
            fileSystem.setRealPath("localhost/123");
            fileSystem.setRelativePath("helloworld");

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

    public static void main(String...args){
        FileSystemTest fileSystemTest = new FileSystemTest();
        fileSystemTest.buildFileSystem();
    }


}
