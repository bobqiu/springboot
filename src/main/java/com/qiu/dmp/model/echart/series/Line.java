
package com.qiu.dmp.model.echart.series;


import com.qiu.dmp.model.echart.constant.DataFilter;
import com.qiu.dmp.model.echart.constant.SeriesType;

/**
 */
public class Line extends Series<Line> {
    /**
     * 平滑曲线
     */
    private Boolean smooth;
    /**
     * ECharts 会在折线图的数据数量大于实际显示的像素宽度（高度）的时候会启用优化，对显示在一个像素宽度内的数据做筛选，该选项是指明数据筛选的策略
     */
    private Object dataFilter;

    /**
     * 构造函数
     */
    public Line() {
        this.type(SeriesType.line);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Line(String name) {
        super(name);
        this.type(SeriesType.line);
    }

    /**
     * 获取dataFilter值
     */
    public Object dataFilter() {
        return this.dataFilter;
    }

    /**
     * 设置dataFilter值
     *
     * @param dataFilter
     */
    public Line dataFilter(Object dataFilter) {
        this.dataFilter = dataFilter;
        return this;
    }

    /**
     * 设置dataFilter值
     *
     * @param dataFilter
     */
    public Line dataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
        return this;
    }

    /**
     * 获取smooth值
     */
    public Boolean smooth() {
        return this.smooth;
    }

    /**
     * 设置smooth值
     *
     * @param smooth
     */
    public Line smooth(Boolean smooth) {
        this.smooth = smooth;
        return this;
    }

    /**
     * 获取smooth值
     */
    public Boolean getSmooth() {
        return smooth;
    }

    /**
     * 设置smooth值
     *
     * @param smooth
     */
    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }

    /**
     * 获取dataFilter值
     */
    public Object getDataFilter() {
        return dataFilter;
    }

    /**
     * 设置dataFilter值
     *
     * @param dataFilter
     */
    public void setDataFilter(Object dataFilter) {
        this.dataFilter = dataFilter;
    }
}
