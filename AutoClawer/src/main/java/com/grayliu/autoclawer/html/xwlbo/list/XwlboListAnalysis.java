package com.grayliu.autoclawer.html.xwlbo.list;

import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.HtmlAnalysis;
import com.grayliu.autoclawer.service.impl.XwlboListClawer;
import org.eclipse.jetty.util.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuhui-ds9 on 2018/12/26.
 */
@Component
public class XwlboListAnalysis extends HtmlAnalysis<String, String> {

    public static Pattern pattern = Pattern.compile("^(\\d+年\\d+月\\d+).*");

    /**
     * 返回日期与url的集合
     * @param document
     * @return
     */
    @Override
    public Map<String, String> analysis(Document document) {
        Map<String, String> rtn = new TreeMap<String, String>(
                new Comparator<String>() {
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    @Override
                    public int compare(String o1, String o2) {
                        try {
                            Date d1 = sdf.parse(o1);
                            Date d2 = sdf.parse(o2);
                            if(d1.getTime() < d2.getTime()){
                                return 1;
                            }else{
                                return -1;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return 1;
                    }
                });
        Elements elements = document.select("ol.xwlist li");
        for(Element element : elements){
            //得到a标签
            Element ele = element.child(1);
            String path = ele.attr("href");
            String date = ele.html();
            date = formatDate(date);
            rtn.put(date, path);
        }
        return rtn;
    }


    private String formatDate(String input){

        String rtn = null;

        if(StringUtil.isBlank(input)){
           return rtn;
        }

        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            rtn = matcher.group(1);
            rtn = rtn.replaceAll("[年|月]","-");
        }
        return rtn;
    }

    public static void main(String...args){
        String input = "2018年12月19日新闻联播文字完整版内容";

        XwlboListAnalysis XwlboListAnalysis = new XwlboListAnalysis();
        System.out.println(XwlboListAnalysis.formatDate(input));

    }

}
