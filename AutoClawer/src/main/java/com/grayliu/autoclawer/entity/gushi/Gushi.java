package com.grayliu.autoclawer.entity.gushi;

import lombok.Data;

import java.sql.Timestamp;
import java.sql.Date;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
@Data
public class Gushi {

    Integer id;

    String author;

    String age;

    String title;

    String content;

    String url;

    String category;

    Integer categoryNum;

    Date createTime;

    Timestamp newTime;
}
