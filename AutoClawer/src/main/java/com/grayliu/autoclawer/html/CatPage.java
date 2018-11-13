package com.grayliu.autoclawer.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
public class CatPage {

    public HtmlData ParseHtml(Reader reader) {
        HtmlData wd = null;
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
            if(table.children().size() > 6){
                Element row = table.child(6);
                wd = new HtmlData();
                wd.setName(row.child(0).text());
                wd.setTotal(row.child(1).text());
                wd.setFailure(row.child(2).text());
                wd.setFailurePercent(row.child(3).text());
                wd.setSampleLink(row.child(4).text());
                wd.setMin(row.child(5).text());
                wd.setMax(row.child(6).text());
                wd.setAvg(row.child(7).text());
                wd.setLine95(row.child(8).text());
                wd.setLine99(row.child(9).text());
                wd.setStd(row.child(10).text());
                wd.setQps(row.child(11).text());
                wd.setPercent(row.child(12).text());
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

    public static void main(String...args) throws IOException {

        File file = new File("D:\\ProjectMine\\MyTest\\AutoClawer\\src\\main\\resources\\CatPage.html");


//        System.out.println(wd.toString());
//        System.out.println(row.toString());

    }
}
