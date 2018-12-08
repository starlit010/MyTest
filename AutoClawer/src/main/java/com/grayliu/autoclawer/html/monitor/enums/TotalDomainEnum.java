package com.grayliu.autoclawer.html.monitor.enums;

/**
 * Created by liuhui-ds9 on 2018/11/11.
 */
public enum TotalDomainEnum {

    Cheap("stage-cheap-dubbo"),Item("item-app"),Price("price_service"),Detail("gome-detail-service");

    String domain;

    TotalDomainEnum(String domain){
        this.domain = domain;
    }

    public String getDomain(){
        return domain;
    }


}
