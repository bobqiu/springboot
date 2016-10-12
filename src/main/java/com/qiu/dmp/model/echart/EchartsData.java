package com.qiu.dmp.model.echart;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/10.
 */
public class EchartsData {

    private List<String> legend = new ArrayList<String>();//数据分组
    private List<String> category = new ArrayList<String>();//横坐标
    private List<Series> series = new ArrayList<Series>();//纵坐标


    public EchartsData(List<String> legend, List<String> category, List<Series> series) {
        this.legend = legend;
        this.category = category;
        this.series = series;
    }

}
