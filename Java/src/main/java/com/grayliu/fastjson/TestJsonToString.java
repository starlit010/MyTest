package com.grayliu.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by liuhui-ds9 on 2018/10/11.
 */
public class TestJsonToString {

    public static void main(String...args){

//        test1();
//        test2();
        test4();
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


    public static void test3(){

        String str = "[\"北京：\",\"10℃\",\"优\",\"|\",\"查看天气信息，\",\"设置城市\",\"换肤\",\"消息\",\"显示频道\",\"新闻\",\"hao123\",\"地图\",\"视频\",\"贴吧\",\"学术\",\"starlit009\",\"设置\",\"更多产品\",\"个人中心\",\"帐号设置\",\"意见反馈\",\"退出\",\"搜索设置\",\"高级搜索\",\"搜索历史\",\"意见反馈\",\"输入法\",\"手写\",\"拼音\",\"关闭\",\"百度首页\",\"消息\",\"设置\",\"starlit009\",\"手机百度\",\"快人一步\",\"百度糯米\",\"我的生活\",\"设为首页\",\"©2018 Baidu\",\"使用百度前必读\",\"意见反馈\",\"京ICP证030173号\",\"京公网安备11000002000001号\",\"网页\"]";

        JSONArray jsonArray = JSONArray.parseArray(str);

        System.out.println(jsonArray.get(1));


    }

    public static void test4(){

        String str =  "[\"北京：\",\"10℃\",\"优\",\"|\",\"查看天气信息，\",\"设置城市\",\"换肤\",\"消息\",\"显示频道\",\"新闻\",\"hao123\",\"地图\",\"视频\",\"贴吧\",\"学术\",\"starlit009\",\"设置\",\"更多产品\",\"个人中心\",\"帐号设置\",\"意见反馈\",\"退出\",\"搜索设置\",\"高级搜索\",\"搜索历史\",\"意见反馈\",\"输入法\",\"手写\",\"拼音\",\"关闭\",\"百度首页\",\"消息\",\"设置\",\"starlit009\",\"手机百度\",\"快人一步\",\"百度糯米\",\"我的生活\",\"设为首页\",\"©2018 Baidu\",\"使用百度前必读\",\"意见反馈\",\"京ICP证030173号\",\"京公网安备11000002000001号\",\"网页\"]";

        String str1 = str.substring(1,str.length() - 1);

        String[] str1Array = str1.split(",");

//        System.out.println(str1Array[str1Array.length - 1] );

//        System.out.println(Arrays.toString(str1Array));

        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");

        System.out.println(Arrays.toString(new String[]{"a","b"}));


    }

}
