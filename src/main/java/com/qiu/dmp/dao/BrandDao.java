package com.qiu.dmp.dao;


import com.qiu.dmp.model.Brand;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface BrandDao {
    public List<Brand> getBrands();

    public void createBrands(Brand brand);

    public void deleteByName(String name);

    public Integer getAllBrands();

    public List<Brand> getBrandByName(String name);

}
