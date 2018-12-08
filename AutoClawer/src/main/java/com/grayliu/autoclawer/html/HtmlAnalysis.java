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
public abstract class HtmlAnalysis {

    protected Map<ContentType, Object> rtnMap = new HashMap<ContentType, Object>();

    public abstract Map<ContentType,Object> analysis(Document document);

}
