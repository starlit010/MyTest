package com.grayliu.autoclawer.html;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */

@Data
public class WatchData {

    String name;
    String total;
    String failure;
    String failurePercent;
    String sampleLink;
    String min;
    String max;
    String avg;
    String line95;
    String line99;
    String std;
    String qps;
    String percent;

}
