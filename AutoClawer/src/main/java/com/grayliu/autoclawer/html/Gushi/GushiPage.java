package com.grayliu.autoclawer.html.gushi;

import com.grayliu.autoclawer.html.monitor.HtmlData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
public class GushiPage {

    public String parseHtml(Reader reader) {
        HtmlData wd = null;
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            Document doc = Jsoup.parse(sb.toString());
            Elements items = doc.getElementsByClass("contson");
            Element item = items.get(0);
            return item.html();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

}
