package com.grayliu.autoclawer.entity.xwlbo;

import lombok.Data;

import java.io.InputStream;
import java.sql.Blob;

/**
 * Created by liuhui-ds9 on 2018/11/29.
 */
@Data
public class FileSystem {

    Integer id;

    String location;

    String realPath;

    String relativePath;

    byte[] content;

}
