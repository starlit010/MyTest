package com.grayliu.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/10/11.
 */
public class TestJsonToString {

    public static void main(String...args){

//        test1();
        test2();

    }

    public static void test1(){
        TestEnum t = TestEnum.A;

        String str =  JSON.toJSONString(t);

        System.out.println(str);

        Map<String,Long> map = new HashMap<String,Long>();

        map.put("H",1L);
        map.put("B",2L);

        System.out.println(JSON.toJSONString(map));
    }

    public static void test2(){

        String str = "{\n" +
                "    \"translation\": [\n" +
                "        {\n" +
                "            \"translated\": [\n" +
                "                {\n" +
                "                    \"src-tokenized\": [\n" +
                "                        \"english\"\n" +
                "                    ], \n" +
                "                    \"score\": -1, \n" +
                "                    \"rank\": 0, \n" +
                "                    \"text\": \"英语\"\n" +
                "                }\n" +
                "            ], \n" +
                "            \"translationId\": \"5b7c14304b184542b4d8c9555f17bd8d\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONObject jsonObject = (JSONObject)JSONObject.parse(str);
        JSONArray translation = (JSONArray)jsonObject.get("translation");
        JSONObject translated0 = (JSONObject)translation.get(0);
        JSONArray translated = (JSONArray)translated0.get("translated");
        JSONObject translatedItem = (JSONObject)translated.get(0);

        System.out.println(translatedItem);
    }


    enum TestEnum{

        A("hello"),B("world");

        String testString;

        TestEnum(String str){
            this.testString = str;
        }
    }



}
