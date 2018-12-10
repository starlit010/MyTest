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

    List<HtmlInfo> searchList;

    @Override
    public void clawerHtml() {
        super.setAnalysis(xwlboAnalysis);
        for(HtmlInfo htmlInfo : searchList){
            String realPath = htmlInfo.getRealPath();
            Document document = HttpClientUtil.httpGetDocument(realPath);
            Map<ContentType, Object> contentMap = htmlAnalysis.analysis(document);
            Set<Map.Entry<ContentType, Object>> set = contentMap.entrySet();
            if(set.size() > 0){
                set.forEach( (item) -> {
                    ContentType contentType = item.getKey();
                    switch(contentType){
                        case text:
                            List<Xwlbo> texts = (List<Xwlbo>)item.getValue();
                            saveContent(texts, htmlInfo.getRealPath(), htmlInfo.getDateStr());
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

    @Override
    public <T> void saveContent(List<T> list, Object... obj) {
        List<Xwlbo> xwlboList = (List<Xwlbo>)list;
        xwlboList.forEach((item) -> {
            Date date = new Date(DataFormatUtil.getDateTime((String)obj[0],sdf));
            URL url = DataFormatUtil.parseUrl((String)obj[1]);
            String location = url.getHost();
            String relativePath = url.getPath();
            item.setLocation(location);
            item.setRealPath((String)obj[1]);
            item.setRelativePath(relativePath);
            item.setNewsDate(date);
        });
        xwlboDao.insertList(xwlboList);
    }

    public void setSearchList(List<HtmlInfo> xwlbos){
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

    private void saveFile(String url){
        FileSystem fileSystem = HttpClientUtil.httpGetFile(url);
        fileSystemDao.insert(fileSystem);
    }

    public class HtmlInfo{
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
