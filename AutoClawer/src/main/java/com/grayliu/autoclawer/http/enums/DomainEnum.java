package com.grayliu.autoclawer.http.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */
public enum DomainEnum {

    Cheap("stage-cheap-dubbo"),Item("item-app"),Price("price_service"),Wireless("gome_wireless");

    String domain;

    List<String> cheaps = new ArrayList<String>();
    List<String> items = new ArrayList<String>();
    List<String> prices = new ArrayList<String>();
    List<String> wirelesses = new ArrayList<String>();

    DomainEnum(String domain){
        init();
        this.domain = domain;
    }

    public String getDomain(){
        return domain;
    }

    private void init(){
        cheaps.add("IRushBuyInterface.getRushbuyIndexPageData");
        cheaps.add("IGrouponInterface.getBrandDetailPageData");
        cheaps.add("ICheapServiceInterface.getRushBuyStatus");
        cheaps.add("ICheapServiceInterface.getGroupOnByItemId");
        cheaps.add("ICheapServiceInterface.getGroupOnStatus");
        cheaps.add("IGrouponInterface.getGrouponDetailPageData");
        cheaps.add("IGrouponInterface.getGrouponIndexPageData");
        cheaps.add("ICheapServiceInterface.getRushBuyByItemId");
        items.add("IGomeProductService.getProductInfo");
        items.add("IGomeRebateService.getPrdsRebates");
        items.add("IProdDetailService.getProductMultiProperties");
        items.add("IProdDetailService.getSkuMultiProperties");
        items.add("IGomeRebateService.getPrdRebate");
        items.add("IProductInfoService.getGoodsInfos");
        prices.add("IPriceService.getAreaPrice");
        prices.add("IPriceService.getGroupOnPrice");
        prices.add("IPriceService.getRushBuyPrice");
        prices.add("IPriceService.getGomePrice");
        prices.add("IPriceService.getGomePrices");
        prices.add("IGomePriceService.shoppingCartPrice");
        prices.add("IPriceService.getMobileProdPrice");
        prices.add("IPriceService.getFinalPalmAreaPrice");
        prices.add("IPriceService.getPalmPrice");
        prices.add("IPriceService.getMobileProdPrices");
        wirelesses.add("IWirelessService.getFuseProductInfo");
        wirelesses.add("IWirelessService.getFuseAppraiseInfo");
    }

    public List<String> getQuery(DomainEnum domain){
        switch(domain){
            case Cheap:
                return cheaps;
            case Item:
                return items;
            case Price:
                return prices;
            case Wireless:
                return wirelesses;
            default:
                return null;
        }
    }

}
