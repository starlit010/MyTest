package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.dao.XwlboDao;
import com.grayliu.autoclawer.entity.xwlbo.FileSystem;
import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.xwlbo.XwlboAnalysis;
import com.grayliu.autoclawer.service.ClawerInterface;
import com.grayliu.autoclawer.util.HttpClientUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@Service
public class XwlboClawer extends ClawerInterface {

    String realPath = "http://xwlbo.com/19968.html";

    String location = "xwlbo.com";

    String relativePath = "19968.html";

    String dateStr = "2018-11-30";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    XwlboDao xwlboDao;

    @Autowired
    FileSystemDao fileSystemDao;

    @Autowired
    XwlboAnalysis xwlboAnalysis;

    @Override
    public void clawerHtml() {
        super.setAnalysis(xwlboAnalysis);
        Document document = HttpClientUtil.httpGetDocument(realPath);
        Map<ContentType, Object> contentMap = htmlAnalysis.analysis(document);
        Set<Map.Entry<ContentType, Object>> set = contentMap.entrySet();
        if(set.size() > 0){
            set.forEach( (item) -> {
                ContentType contentType = item.getKey();
                switch(contentType){
                    case text:
                        List<Xwlbo> texts = (List<Xwlbo>)item.getValue();
                        saveText(texts);
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

    private void saveText(List<Xwlbo> xwlboList) {
        try {
            final Date date = new Date(sdf.parse(dateStr).getTime());
            URL url = new URL(realPath);
            String location = url.getHost();
            String realPath = url.toString();
            String relativePath = url.getPath();
            xwlboList.forEach((item) -> {
                item.setLocation(location);
                item.setRealPath(realPath);
                item.setRelativePath(relativePath);
                item.setNewsDate(date);
            });
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        xwlboDao.insertList(xwlboList);
    }

    private void saveFile(String url){
        FileSystem fileSystem = HttpClientUtil.httpGetFile(url);
        fileSystemDao.insert(fileSystem);
    }
}
