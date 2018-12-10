package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.dao.EnglishDao;
import com.grayliu.autoclawer.dao.FileSystemDao;
import com.grayliu.autoclawer.dao.XwlboDao;
import com.grayliu.autoclawer.entity.english.English;
import com.grayliu.autoclawer.entity.fileSystem.FileSystem;
import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.english.EnglishAnalysis;
import com.grayliu.autoclawer.html.xwlbo.XwlboAnalysis;
import com.grayliu.autoclawer.service.AbstractClawer;
import com.grayliu.autoclawer.util.DataFormatUtil;
import com.grayliu.autoclawer.util.HttpClientUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@Service
public class EnglishClawer extends AbstractClawer {

//    String realPath = "http://xwlbo.com/19968.html";
//
//    String location = "xwlbo.com";
//
//    String relativePath = "19968.html";
//
//    String dateStr = "2018-11-30";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    EnglishDao englishDao;

    @Autowired
    FileSystemDao fileSystemDao;

    @Autowired
    EnglishAnalysis englishAnalysis;

    List<HtmlInfo> searchList;

    @Override
    public void clawerHtml() {
        super.setAnalysis(englishAnalysis);
        try {
            for(HtmlInfo htmlInfo : searchList){
                String realPath = htmlInfo.getRealPath();
                Document document = HttpClientUtil.httpGetDocument(realPath);
                Thread.sleep(1000L);
                Map<ContentType, Object> contentMap = htmlAnalysis.analysis(document);
                Set<Map.Entry<ContentType, Object>> set = contentMap.entrySet();
                if(set.size() > 0){
                    set.forEach( (item) -> {
                        ContentType contentType = item.getKey();
                        switch(contentType){
                            case text:
                                List<English> texts = (List<English>)item.getValue();
                                saveContent(texts, htmlInfo.getLevel());
                                break;
                            case avi:
                                //保存声音文件
                                break;
                            default: break;
                        }
                    });
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void saveContent(List<T> contentList,Object...obj) {
        List<English> englishList = (List<English>)contentList;
        englishList.forEach((item) -> {
            item.setLvl((Integer)obj[0]);
        });
        englishDao.insertList(englishList);
    }

    public void setSearchList(List<HtmlInfo> htmlInfos){

        if(htmlInfos == null){
            htmlInfos = new ArrayList<HtmlInfo>();

            for(int lvl = 1 ; lvl <= 7 ; lvl++){
                for(int page = 1 ; page <= 50 ; page++){
                    String url = "http://word.qsbdc.com/wl.php?level="+lvl+"&&tag=all&&page_id="+ page;
                    HtmlInfo htmlInfo = new HtmlInfo();
                    htmlInfo.setLevel(lvl);
                    htmlInfo.setRealPath(url);
                    htmlInfos.add(htmlInfo);
                }
            }
        }
//        xwlbo1.setDateStr("2018-12-0、65");
//        Xwlbo xwlbo2 = new Xwlbo();
//        xwlbo2.setRealPath("http://xwlbo.com/20075.html");
//        xwlbo2.setDateStr("2018-12-05");
//        searchList.add(xwlbo1);
//        searchList.add(xwlbo2);
        this.searchList = htmlInfos;
    }


    public class HtmlInfo{
        String realPath;
        Integer level = 1;

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getRealPath() {
            return realPath;
        }

        public void setRealPath(String realPath) {
            this.realPath = realPath;
        }
    }
}
