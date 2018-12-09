package com.grayliu.autoclawer.html;

import com.grayliu.autoclawer.html.ContentType;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 *
 * 定义页面解析规则的模板方法
 *
 */
public abstract class HtmlAnalysis<K,V> {

    protected Map<K, V> rtnMap = new HashMap<K, V>();

    public abstract Map<K,V> analysis(Document document);

}
