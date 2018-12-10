package com.grayliu.autoclawer.controller;

import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.entity.fileSystem.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/12/4.
 */

@Controller
@RequestMapping(value="fileSystem")
public class FileController {

    @Autowired
    FileSystemDao fileSystemDao;

    @RequestMapping(value="getFile",method= RequestMethod.GET)
    public void getFile(HttpServletRequest request, HttpServletResponse response){
        String path = request.getParameter("path");
        FileSystem fileSystemParam = new FileSystem();
        fileSystemParam.setRealPath(path);
        List<FileSystem> fileResults = fileSystemDao.queryList(fileSystemParam);
        if(fileResults.size() > 0 ){
            FileSystem fileSystem = fileResults.get(0);
            byte[] bytes = fileSystem.getContent();
            String contentType = fileSystem.getContentType();
            try {
                response.setContentType(contentType);
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
//                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
