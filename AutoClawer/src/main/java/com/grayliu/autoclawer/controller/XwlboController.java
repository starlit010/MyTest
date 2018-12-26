package com.grayliu.autoclawer.controller;

import com.grayliu.autoclawer.bean.xwlbo.HtmlInfo;
import com.grayliu.autoclawer.bean.xwlbo.ListInfo;
import com.grayliu.autoclawer.dao.XwlboDao;
import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.html.xwlbo.XwlboAnalysis;
import com.grayliu.autoclawer.service.impl.XwlboClawer;
import com.grayliu.autoclawer.service.impl.XwlboListClawer;
import com.grayliu.autoclawer.util.DataFormatUtil;
import org.eclipse.jetty.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/12/6.
 */
@Controller
public class XwlboController {

    @Autowired
    public XwlboDao xwlboDao;

    @Autowired
    public XwlboClawer xwlboClawer;

    @Autowired
    public XwlboListClawer xwlboListClawer;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    Logger logger = LoggerFactory.getLogger(XwlboController.class);

    @RequestMapping(value="/xwlbo/{dateStr}",method = RequestMethod.GET)
//    @ResponseBody
    public ModelAndView getXwlbo(ModelMap map, @PathVariable String dateStr, HttpServletRequest request, HttpServletResponse response){
        Xwlbo xwlbo = new Xwlbo();
        xwlbo.setNewsDate(DataFormatUtil.getDate(dateStr, new SimpleDateFormat("yyyy-MM-dd")));
        logger.info("datenews-dateStr: " + dateStr);
        List<Xwlbo> xwlboList = xwlboDao.queryList(xwlbo);
//        logger.info(String.valueOf(xwlboList));
        ModelAndView modelAndView = new ModelAndView();
        map.put("xwlbos", xwlboList);
        modelAndView.setViewName("xwlbo/xwlbo");
        return modelAndView;
    }

    @RequestMapping(value="/xwlbo/clawer",method = RequestMethod.GET)
    @ResponseBody
    public void clawer(HttpServletRequest request, HttpServletResponse response){
        String dateStr = request.getParameter("date");
        String realPath = request.getParameter("path");

        HtmlInfo htmlInfo = new HtmlInfo();
        htmlInfo.setDateStr(dateStr);
        htmlInfo.setRealPath(realPath);

        List<HtmlInfo> xwlboList = new ArrayList<HtmlInfo>();
        xwlboList.add(htmlInfo);

        xwlboClawer.setSearchList(xwlboList);

        System.out.println(dateStr + ":" + realPath);
        xwlboClawer.clawerHtml();
    }

    /**
     * 默认每页30条记录和xwlbo.com一致
     * 先查网页，然后查数据库，已经有记录的直接显示链接，没有记录的补全查询页面
     * http://xwlbo.com/txt.html
     * @param map
     * @param page
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/xwlbo",method = RequestMethod.GET)
    public ModelAndView getList(ModelMap map, @RequestParam(required=false) Integer page, HttpServletRequest request, HttpServletResponse response){

        String clawerUrl = null;
        if(page == null || page == 0){
            page = 1;
            clawerUrl = "http://xwlbo.com/txt.html";
        }else{
            clawerUrl = "http://xwlbo.com/txt_" + page + ".html";
        }

        xwlboListClawer.setUrl(clawerUrl);
        Map<String, String> rtn = xwlboListClawer.clawerHtml();
        Iterator<Map.Entry<String,String>> iterator = rtn.entrySet().iterator();

        List<ListInfo> listInfos = new ArrayList<ListInfo>();
        while(iterator.hasNext()){
            ListInfo listInfo = new ListInfo();
            Map.Entry<String, String> entry = iterator.next();
            String date = entry.getKey();
            String path = entry.getValue();
            Xwlbo xwlbo = new Xwlbo();
            try {
                xwlbo.setNewsDate(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<Xwlbo> xwlbos = xwlboDao.queryList(xwlbo);
            if(xwlbos != null && xwlbos.size() > 0){
                String url = "http://localhost/xwlbo/"+ date;
                listInfo.setUrl(url);
            }
            listInfo.setDate(date);
            listInfo.setPath(path);
            listInfos.add(listInfo);
        }
//        listInfo.setDate("2018-12-25");
//        listInfo.setUrl("localhost/xwlbo/2018-12-25");
//        ListInfo listInfo1 = new ListInfo();
//        listInfo1.setDate("2018-12-22");
//        listInfo1.setPath("http://xwlbo.com/20460.html");
//        listInfos.add(listInfo);
//        listInfos.add(listInfo1);

        ModelAndView modelAndView = new ModelAndView();
        map.put("xwlbos", listInfos);
        map.put("page", page);
        modelAndView.setViewName("xwlbo/list");
        return modelAndView;
    }

}
