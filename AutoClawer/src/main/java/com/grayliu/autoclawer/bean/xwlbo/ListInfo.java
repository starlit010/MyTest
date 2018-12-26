package com.grayliu.autoclawer.bean.xwlbo;

import lombok.Data;

/**
 * Created by liuhui-ds9 on 2018/12/26.
 */
@Data
public class ListInfo {

    public String date;

    //xwlbo.com网站的url地址
    public String path;

    //已抓取的页面地址
    public String url;

}
