package com.grayliu.autoclawer.service;

import com.grayliu.autoclawer.html.HtmlAnalysis;
import com.grayliu.autoclawer.html.monitor.HtmlData;

import java.io.Reader;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
public abstract class AbstractClawer {

    public HtmlAnalysis htmlAnalysis;

    public void setAnalysis(HtmlAnalysis htmlAnalysis){
        this.htmlAnalysis = htmlAnalysis;
    }

    public abstract void clawerHtml();

}
