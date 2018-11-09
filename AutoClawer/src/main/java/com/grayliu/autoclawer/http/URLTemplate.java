package com.grayliu.autoclawer.http;

import com.grayliu.autoclawer.http.enums.DomainEnum;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
public class URLTemplate {

    static String temp = "http://10.58.52.202:8080/cat/r/t?" + "ip=" + "All" + "&date=#{date}" + "&type=" + "PigeonService" + "&domain=#{domain}&queryname=#{queryName}";

    public static Map<String, String> getUrl(DomainEnum domain,String date){
        Map<String,String> rtnList = new HashMap<String, String>();

        String temp1 = temp.replace("#{domain}", domain.getDomain()).replace("#{date}", date);

        List<String> queryName = domain.getQuery(domain);

        queryName.forEach(query -> rtnList.put(query, temp1.replace("#{queryName}", query)));

        return rtnList;
    }

    public static void main(String...args){
        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());
        System.out.println(URLTemplate.getUrl(DomainEnum.Cheap,date));
    }

}
