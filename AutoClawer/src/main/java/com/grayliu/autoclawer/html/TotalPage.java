package com.grayliu.autoclawer.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by liuhui-ds9 on 2018/11/11.
 */
public class TotalPage {

    public HtmlData ParseHtml(Reader reader) {
        final HtmlData wd = new HtmlData();;
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            Document doc = Jsoup.parse(sb.toString());
            Elements items = doc.getElementsByClass("table table-striped table-condensed table-hover ");
            Element item = items.get(0);
            Element table = item.child(0);

            if(table != null && table.children().size() > 6){
                Elements elements = table.children();
                elements.forEach(element -> {
                    Elements pigeon = element.select("tr > td > a[href~=.*PigeonService]");
                    if(pigeon != null && pigeon.size() > 0){
                        wd.setName(element.child(0).text());
                        wd.setTotal(element.child(1).text());
                        wd.setFailure(element.child(2).text());
                        wd.setFailurePercent(element.child(3).text());
                        wd.setSampleLink(element.child(4).text());
                        wd.setMin(element.child(5).text());
                        wd.setMax(element.child(6).text());
                        wd.setAvg(element.child(7).text());
                        wd.setLine95(element.child(8).text());
                        wd.setLine99(element.child(9).text());
                        wd.setStd(element.child(10).text());
                        wd.setQps(element.child(11).text());
                    }
                });
//                wd.setPercent(row.child(12).text());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return wd;
    }

}
