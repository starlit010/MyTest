package com.grayliu.autoclawer.dao;

import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/21.
 */
public interface BaseDao<T> {
    int insertList(List<T> list);

    int insert(T t);

    List<T> queryList(T t);

    T queryById(Integer id);
}
