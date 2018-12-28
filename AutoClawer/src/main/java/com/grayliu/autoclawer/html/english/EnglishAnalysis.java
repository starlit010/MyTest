package com.grayliu.autoclawer.html.english;

import com.grayliu.autoclawer.entity.english.English;
import com.grayliu.autoclawer.html.ContentType;
import com.grayliu.autoclawer.html.HtmlAnalysis;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  英文翻译网站
 *  http://word.qsbdc.com/wl.php?level=1
 */

@Component
public class EnglishAnalysis extends HtmlAnalysis<ContentType, List<English>> {

    @Override
    public Map<ContentType,List<English>> analysis(Document document) {

        Map<ContentType,List<English>> rtn = new HashMap<ContentType,List<English>>();

        List<English> englishs = new ArrayList<English>();

        Elements trs = document.select("table[class=table_solid] > tbody > tr");

        for(int i = 2 ; i < trs.size() - 1 ; i++){

            Elements tds = trs.get(i).select("td");

            English english = new English();

            String eng = "";

            for(int j = 0 ; j < tds.size() ; j++){

                Element td = tds.get(j);

                switch(j){
                    case 2:
                        eng = td.select("div span").html();
                        english.setEnglish(eng);break;
                    case 3:
                        String sym = td.select("div span").html();
                        english.setSymbol(sym);break;
                    case 5:
                        String chn = td.select("div span").html();
                        String[] chnArray = chn.split("\\.", 2);
                        if(chnArray.length == 2){
                            english.setProperty(chnArray[0]);
                            english.setChinese(chnArray[1]);
                        }else{
                            english.setChinese(chn);
                        }
                        break;
                    case 6:
                        String sent = td.select("a").attr("title").toString();
                        sent = sent.replace("单词 "+ eng +" 的例句||||","");
                        sent = sent.replace("||||","\r\n");
                        english.setSentence(sent);break;
                    default:break;

                }

                if(j == tds.size() - 1){
                    englishs.add(english);
                }
            }
        }
        rtn.put(ContentType.text, englishs);
        return rtn;
    }


    public static void main(String...args){

        String str = "vi. 发低哼声 vt. 用哼声表示 n. 嗡嗡声；哼声；杂声";
        String[] strArray = str.split("\\.",2);
        System.out.println(strArray.length + strArray[0] + strArray[1]);

    }

}
