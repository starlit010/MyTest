package com.grayliu.autoclawer.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuhui-ds9 on 2018/12/5.
 */
public class DataFormatUtil {

    public static Long getDateTime(String dateStr,SimpleDateFormat sdf){
        Date rtnDate = null;
        try {
            rtnDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(rtnDate != null){
            return rtnDate.getTime();
        }else{
            return 0L;
        }
    }

    public static Date getDate(String dateStr,SimpleDateFormat sdf){
        Date rtnDate = null;
        try {
            rtnDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(rtnDate != null){
            return rtnDate;
        }else{
            return new Date();
        }
    }

    public static URL parseUrl(String url){
        URL rtnUrl = null;
        try {
            rtnUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return rtnUrl;
    }


}
