package com.grayliu.autoclawer.entity.xwlbo;

import lombok.Data;

import java.sql.Date;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 */
@Data
public class Xwlbo {

    Integer id;

    String location;

    String realPath;

    String relativePath;

    String title;

    String content;

    Date newsDate;

    Date createDate;

}
