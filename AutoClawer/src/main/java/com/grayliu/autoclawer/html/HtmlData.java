package com.grayliu.autoclawer.html;


import com.grayliu.autoclawer.xmlx.ValueData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuhui-ds9 on 2018/11/9.
 */

@Data
public class HtmlData {

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

    public ValueData convert(){
        ValueData valueData = new ValueData();
        valueData.setLine95(line95);
        valueData.setFailture(failure);
        valueData.setQps(qps);
        valueData.setAvg(avg);
        valueData.setTotal(total);
        return valueData;
    }

    public String getFailurePercent(){
        return failurePercent.substring(1);
    }

}
