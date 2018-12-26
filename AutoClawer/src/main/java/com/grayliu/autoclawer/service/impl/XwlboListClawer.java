package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.bean.xwlbo.HtmlInfo;
import com.grayliu.autoclawer.html.xwlbo.list.XwlboListAnalysis;
import com.grayliu.autoclawer.service.AbstractClawer;
import com.grayliu.autoclawer.util.HttpClientUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/12/26.
 */
@Service
public class XwlboListClawer extends AbstractClawer {

    @Autowired
    XwlboListAnalysis xwlboAnalysisList;

    String url = null;

    @Override
    public Map<String, String> clawerHtml() {
        super.setAnalysis(xwlboAnalysisList);
        Document document = HttpClientUtil.httpGetDocument(url);
        Map<String, String> rtn = xwlboAnalysisList.analysis(document);
        return rtn;
    }

    @Override
    public <T> void saveContent(List<T> list, Object... obj) {

    }

    public void setUrl(String url) {
        this.url = url;
    }
}
