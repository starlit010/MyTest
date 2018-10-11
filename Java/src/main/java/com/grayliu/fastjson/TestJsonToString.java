package com.grayliu.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/10/11.
 */
public class TestJsonToString {

    public static void main(String...args){

        TestEnum t = TestEnum.A;

        String str =  JSON.toJSONString(t);

        System.out.println(str);

        Map<String,Long> map = new HashMap<String,Long>();

        map.put("H",1L);
        map.put("B",2L);

        System.out.println(JSON.toJSONString(map));


    }


    enum TestEnum{

        A("hello"),B("world");

        String testString;

        TestEnum(String str){
            this.testString = str;
        }
    }



}
