package com.grayliu.autoclawer.entity.xwlbo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.*;
import java.sql.*;

/**
 * Created by liuhui-ds9 on 2018/11/29.
 *
 * 目前mybatis支持byte[]直接转成blob类型,如果不支持可以使用此类进行转换
 * typtHandler=com.grayliu.autoclawer.entity.xwlbo.BlobTypeHandler
 * 注意数据库连接要支持字节码
 *
 */
public class BlobTypeHandler extends BaseTypeHandler<byte[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, byte[] bytes, JdbcType jdbcType) throws SQLException {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        preparedStatement.setBlob(4,inputStream);
    }

    @Override
    public byte[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Blob blob = (Blob) resultSet.getBlob(s);
        byte[] retVal = null;
        if (null != blob) {
            InputStream inputStream = blob.getBinaryStream();
            try {
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int length = inputStream.read(buffer);
                while(length > 0){
                    byteArrayOutputStream.write(buffer);
                    length = inputStream.read(buffer);
                }
                retVal = byteArrayOutputStream.toByteArray();

                inputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retVal;
    }

    @Override
    public byte[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public byte[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
