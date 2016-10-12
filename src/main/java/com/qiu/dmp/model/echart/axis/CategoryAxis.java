
package com.qiu.dmp.model.echart.axis;


import com.qiu.dmp.model.echart.constant.AxisType;

/**
 * 类目轴
 */
public class CategoryAxis extends Axis<CategoryAxis> {

    /**
     * 构造函数
     */
    public CategoryAxis() {
        this.type(AxisType.category);
    }

}
