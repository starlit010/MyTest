package com.grayliu.autoclawer.html.xwlbo;

import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.HtmlAnalysis;
import com.grayliu.autoclawer.util.HtmlParse;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@Component
public class XwlboAnalysis extends HtmlAnalysis{

    @Override
    public Map<ContentType, Object> analysis(Document document) {
        List<Xwlbo> xwlbos = new ArrayList<Xwlbo>();
        ContentState contentState = new ContentState();
        Elements elements = document.getElementsByAttributeValue("class","text_content");
        Elements ps = elements.select("p");
        StringBuilder title = new StringBuilder();
        StringBuilder content = new StringBuilder();
        ps.forEach( (item) -> {
            String line = item.outerHtml();
            ContentState.State state = contentState.updateState(line);
            switch(state){
                case title:
                    if(title.length()>0 && content.length()>0){
                        Xwlbo xwlbo = new Xwlbo();
                        xwlbo.setTitle(title.toString());
                        xwlbo.setContent(content.toString());
                        xwlbos.add(xwlbo);
                        title.delete(0,title.length());
                        content.delete(0,content.length());
                    }else{
                        String innerHtml = item.html();
                        title.append(HtmlParse.getCycleContent(innerHtml));
                    }
                    break;
                case content:
                    String innerHtml = item.html();
                    content.append(HtmlParse.getCycleContent(innerHtml));break;
                default:break;
            }
        } );
        rtnMap.put(ContentType.text,xwlbos);
        return rtnMap;
    }
}