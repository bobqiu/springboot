
package com.qiu.dmp.model.echart.constant;

/**
 * ECharts 会在折线图的数据数量大于实际显示的像素宽度（高度）的时候会启用优化，对显示在一个像素宽度内的数据做筛选，该选项是指明数据筛选的策略。
 * 可选 'nearest', 'min', 'max', 'average'。或者是使用自定义的筛选函数
 */
public enum DataFilter {
    nearest, min, max, average
}
