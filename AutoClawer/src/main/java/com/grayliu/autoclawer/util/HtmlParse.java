package com.grayliu.autoclawer.util;

import com.alibaba.druid.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 *
 * 解析html格式
 */
public class HtmlParse {

    public static String getContent(String str){
        String rtn = null;
        String reg = "(?<=\\>).*(?=\\</)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            rtn = matcher.group();
        }
        return rtn;
    }

    public static String getCycleContent(String str){
        if(StringUtils.isEmpty(str)){
           return null;
        }
        for(int i = 0 ; i < 3 ; i++){
            if(!StringUtils.isEmpty(str) && str.startsWith("<") && str.endsWith(">")){
                str = getContent(str);
            }else if(!StringUtils.isEmpty(str) && str.startsWith("<")){
                str = str.replaceFirst("<strong>央视网消息</strong>", "");
                str = str.replaceFirst("央视网消息","");
                str = str.replaceFirst("（新闻联播文字版）", "");
                str = str.replaceFirst("（新闻联播）", "");
            }else{
                break;
            }
        }
        return str == null ? "":str;
    }

    public static void main(String...args){
        String line = "<p><strong>央视网消息</strong>3333</p>";
        System.out.println(getCycleContent(line));
    }


}
