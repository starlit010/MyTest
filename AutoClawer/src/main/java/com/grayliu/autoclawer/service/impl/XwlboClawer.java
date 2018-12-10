package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.dao.XwlboDao;
import com.grayliu.autoclawer.entity.fileSystem.FileSystem;
import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.xwlbo.XwlboAnalysis;
import com.grayliu.autoclawer.service.AbstractClawer;
import com.grayliu.autoclawer.util.DataFormatUtil;
import com.grayliu.autoclawer.util.HttpClientUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@Service
public class XwlboClawer extends AbstractClawer {

//    String realPath = "http://xwlbo.com/19968.html";
//
//    String location = "xwlbo.com";
//
//    String relativePath = "19968.html";
//
//    String dateStr = "2018-11-30";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    XwlboDao xwlboDao;

    @Autowired
    FileSystemDao fileSystemDao;

    @Autowired
    XwlboAnalysis xwlboAnalysis;

    List<Xwlbo> searchList;

    @Override
    public void clawerHtml() {
        super.setAnalysis(xwlboAnalysis);
        for(Xwlbo xwlbo : searchList){
            String realPath = xwlbo.getRealPath();
            Document document = HttpClientUtil.httpGetDocument(realPath);
            Map<ContentType, Object> contentMap = htmlAnalysis.analysis(document);
            Set<Map.Entry<ContentType, Object>> set = contentMap.entrySet();
            if(set.size() > 0){
                set.forEach( (item) -> {
                    ContentType contentType = item.getKey();
                    switch(contentType){
                        case text:
                            List<Xwlbo> texts = (List<Xwlbo>)item.getValue();
                            saveText(texts, xwlbo.getRealPath(), xwlbo.getDateStr());
                            break;
                        case jpg:
                            String url = (String)item.getValue();
                            saveFile(url);
                            break;
                        default: break;
                    }
                });
            }
        }
    }

    public void setSearchList(List<Xwlbo> xwlbos){
//        Xwlbo xwlbo1 = new Xwlbo();
//        xwlbo1.setRealPath("http://xwlbo.com/20120.html");
//        xwlbo1.setDateStr("2018-12-0、65");
//        Xwlbo xwlbo2 = new Xwlbo();
//        xwlbo2.setRealPath("http://xwlbo.com/20075.html");
//        xwlbo2.setDateStr("2018-12-05");
//        searchList.add(xwlbo1);
//        searchList.add(xwlbo2);
        this.searchList = xwlbos;
    }

    private void saveText(List<Xwlbo> xwlboList,String realPath, String dateStr) {
        xwlboList.forEach((item) -> {
            Date date = new Date(DataFormatUtil.getDateTime(dateStr,sdf));
            URL url = DataFormatUtil.parseUrl(realPath);
            String location = url.getHost();
            String relativePath = url.getPath();
            item.setLocation(location);
            item.setRealPath(realPath);
            item.setRelativePath(relativePath);
            item.setNewsDate(date);
        });
        xwlboDao.insertList(xwlboList);
    }

    private void saveFile(String url){
        FileSystem fileSystem = HttpClientUtil.httpGetFile(url);
        fileSystemDao.insert(fileSystem);
    }

    class HtmlInfo{
        String realPath;
        String dateStr;

        public String getDateStr() {
            return dateStr;
        }

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
        }

        public String getRealPath() {
            return realPath;
        }

        public void setRealPath(String realPath) {
            this.realPath = realPath;
        }
    }
}
