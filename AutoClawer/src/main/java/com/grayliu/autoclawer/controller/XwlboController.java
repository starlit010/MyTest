package com.grayliu.autoclawer.controller;

import com.grayliu.autoclawer.dao.XwlboDao;
import com.grayliu.autoclawer.entity.xwlbo.Xwlbo;
import com.grayliu.autoclawer.service.impl.XwlboClawer;
import com.grayliu.autoclawer.util.DataFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/12/6.
 */
@Controller
public class XwlboController {

    @Autowired
    public XwlboDao xwlboDao;

    @Autowired
    public XwlboClawer xwlboClawer;

    Logger logger = LoggerFactory.getLogger(XwlboController.class);

    @RequestMapping(value="/xwlbo/{dateStr}",method = RequestMethod.GET)
    @ResponseBody
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

        Xwlbo xwlbo = new Xwlbo();
        xwlbo.setDateStr(dateStr);
        xwlbo.setRealPath(realPath);

        List<Xwlbo> xwlboList = new ArrayList<Xwlbo>();
        xwlboList.add(xwlbo);

        xwlboClawer.setSearchList(xwlboList);

        System.out.println(dateStr + ":" + realPath);
        xwlboClawer.clawerHtml();
    }

}
