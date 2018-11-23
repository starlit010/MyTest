package com.grayliu.autoclawer.service;

import com.grayliu.autoclawer.entity.Gushi;
import com.grayliu.autoclawer.html.HtmlData;
import org.apache.poi.ss.formula.functions.T;

import java.io.Reader;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
public interface GushiInterface<T> {

    public void insertToDB(List<T> gushi);

    public List<T> findObject(HtmlData htmlData);

    public HtmlData parseHtml(Reader reader);

}
