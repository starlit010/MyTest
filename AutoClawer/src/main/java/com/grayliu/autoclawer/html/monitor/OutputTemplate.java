package com.grayliu.autoclawer.html.monitor;

/**
 * Created by liuhui-ds9 on 2018/11/11.
 */
public class OutputTemplate {

    static String template = "交易服务中心-商品研发部\n" +
            "应用：#{APPLICATION}  \n" +
            "时间：#{FROM_TIME}点-#{TO_TIME}点  \n" +
            "总调用量：#{TOTAL}\n" +
            "AVG：#{AVG}ms  \n" +
            "95%line：#{Line95}\n" +
            "QPS：#{QPS}\n" +
            "状态： 正常\n" +
            "值班负责人： 张大鹏 袁野";

    public static String templateItem(String application,String from,String total,String avg,String line95,String qps){

        String rtn = new String();

        switch(application){
            case "stage-cheap-dubbo": rtn = template.replace("#{APPLICATION}","团抢服务");break;
            case "item-app": rtn = template.replace("#{APPLICATION}","PC详情页应用服务");break;
            case "price_service": rtn = template.replace("#{APPLICATION}","价格服务");break;
            case "gome-detail-service": rtn = template.replace("#{APPLICATION}","商品服务");break;
        }

        Integer to = Integer.valueOf(from) + 1;

        rtn = rtn.replace("#{FROM_TIME}", from);
        rtn = rtn.replace("#{TO_TIME}", to.toString());
        rtn = rtn.replace("#{TOTAL}", total);
        rtn = rtn.replace("#{AVG}", avg);
        rtn = rtn.replace("#{Line95}", line95);
        rtn = rtn.replace("#{QPS}", qps);

        return rtn;
    }

}
