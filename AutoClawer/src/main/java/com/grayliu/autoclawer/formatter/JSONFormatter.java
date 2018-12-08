package com.grayliu.autoclawer.formatter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by liuhui-ds9 on 2018/12/6.
 */
public class JSONFormatter implements Formatter<Object> {
    @Override
    public Object parse(String s, Locale locale) throws ParseException {
        if(s != null){
            return JSONObject.parse(s);
        }
        return null;
    }

    @Override
    public String print(Object o, Locale locale) {
        return JSONObject.toJSONString(o);
    }
}
