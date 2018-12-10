package com.grayliu.autoclawer.service.impl;

import com.grayliu.autoclawer.html.monitor.HtmlData;
import com.grayliu.autoclawer.html.monitor.HttpClawer;
import com.grayliu.autoclawer.html.monitor.OutputTemplate;
import com.grayliu.autoclawer.service.AbstractClawer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by liuhui-ds9 on 2018/12/4.
 */
public class MonitorClawer extends AbstractClawer {

    @Override
    public void clawerHtml() {
//        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());
//        String data1 = "2018111118";
//        xlsx(data1);
//        total();
    }

    public static void total(){
        HttpClawer httpClawer = new HttpClawer();
        String date = new SimpleDateFormat("yyyyMMddHH").format(new Date());

        String from = date.substring(8);

        Map<String,HtmlData> result = (httpClawer.startTotalClawer(date));
//        Set<Map.Entry<String, HtmlData>> set = result.entrySet();
//        set.forEach(item -> {
//            if(item != null){
//                if(item.getValue() != null){
//                    System.out.println(item.getKey() + "->" + item.getValue().convert().toString());
//                }else{
//                    System.out.println(item.getKey() + "->" );
//                }
//            }
//        });

        HtmlData detail = result.get("gome-detail-service");
        HtmlData stage = result.get("stage-cheap-dubbo");
        HtmlData item = result.get("item-app");
        HtmlData price = result.get("price_service");

        StringBuffer sb = new StringBuffer();

        sb.append(OutputTemplate.templateItem("gome-detail-service", from, detail.getTotal(), detail.getAvg(), detail.getLine95(), detail.getQps()));
        sb.append("\n----------------------------\n");
        sb.append(OutputTemplate.templateItem("stage-cheap-dubbo",from,stage.getTotal(),stage.getAvg(),stage.getLine95(),stage.getQps()));
        sb.append("\n----------------------------\n");
        sb.append(OutputTemplate.templateItem("item-app",from,item.getTotal(),item.getAvg(),item.getLine95(),item.getQps()));
        sb.append("\n----------------------------\n");
        sb.append(OutputTemplate.templateItem("price_service",from,price.getTotal(),price.getAvg(),price.getLine95(),price.getQps()));


        System.out.println(sb);
    }

    public static void xlsx(String date){
        HttpClawer httpClawer = new HttpClawer();


        String from = date.substring(8);

        Map<String,HtmlData> result = (httpClawer.startClawer(date));
        HtmlData data1 = result.get("IGomeProductService.getProductInfo");
        HtmlData data2 = result.get("IGomeRebateService.getPrdsRebates");
        HtmlData data3 = result.get("IProdDetailService.getProductMultiProperties");
        HtmlData data4 = result.get("IProdDetailService.getSkuMultiProperties");
        HtmlData data5 = result.get("IGomeRebateService.getPrdRebate");
        HtmlData data6 = result.get("IProductInfoService.getGoodsInfos");
        HtmlData data7 = result.get("IPriceService.getAreaPrice");
        HtmlData data8 = result.get("IPriceService.getGroupOnPrice");
        HtmlData data9 = result.get("IPriceService.getRushBuyPrice");
        HtmlData data10 = result.get("IPriceService.getGomePrice");
        HtmlData data11 = result.get("IPriceService.getGomePrices");
        HtmlData data12 = result.get("IGomePriceService.shoppingCartPrice");
        HtmlData data13 = result.get("IPriceService.getMobileProdPrice");
        HtmlData data14 = result.get("IPriceService.getFinalPalmAreaPrice");
        HtmlData data15 = result.get("IPriceService.getPalmPrice");
        HtmlData data16 = result.get("IPriceService.getMobileProdPrices");
        HtmlData data17 = result.get("IWirelessService.getFuseProductInfo");
        HtmlData data18 = result.get("IWirelessService.getFuseAppraiseInfo");
        HtmlData data19 = result.get("IRushBuyInterface.getRushbuyIndexPageData");
        HtmlData data20 = result.get("IGrouponInterface.getBrandDetailPageData");
        HtmlData data21 = result.get("ICheapServiceInterface.getRushBuyStatus");
        HtmlData data22 = result.get("ICheapServiceInterface.getGroupOnByItemId");
        HtmlData data23 = result.get("ICheapServiceInterface.getGroupOnStatus");
        HtmlData data24 = result.get("IGrouponInterface.getGrouponDetailPageData");
        HtmlData data25 = result.get("IGrouponInterface.getGrouponIndexPageData");
        HtmlData data26 = result.get("ICheapServiceInterface.getRushBuyByItemId");

        HtmlData temp = null;
        temp = data1;
        if(temp!=null){
            System.out.println(temp.getTotal()+"\t"+temp.getAvg()+"\t"+temp.getLine95()+"\t"+temp.getFailure()+"\t"+temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data2;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data3;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data4;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data5;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data6;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data7;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data8;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data9;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data10;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data11;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data12;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data13;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data14;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data15;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data16;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data17;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data18;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data19;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data20;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data21;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data22;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data23;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data24;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data25;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }
        temp = data26;
        if(temp!=null) {
            System.out.println(temp.getTotal() + "\t" + temp.getAvg() + "\t" + temp.getLine95() + "\t" + temp.getFailure() + "\t" + temp.getFailurePercent());
        }else{
            System.out.println(""+"\t"+""+"\t"+""+"\t"+""+"\t");
        }





//        Set<Map.Entry<String, HtmlData>> set = result.entrySet();
//        set.forEach(item -> {
//            if(item != null){
//                if(item.getValue() != null){
//                    System.out.println(item.getKey() + "->" + item.getValue().convert().toString());
//                }else{
//                    System.out.println(item.getKey() + "->" );
//                }
//            }
//        });
    }


}
