package com.qiu.dmp.service.impl;


import com.qiu.dmp.dao.BrandDao;
import com.qiu.dmp.model.Brand;
import com.qiu.dmp.service.BrandService;
import com.qiu.dmp.utils.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Value("${name}")
    private String name;

    @Autowired
    private Properties properties;

    @Override
    public List<Brand> getBrands() {

        System.out.println("******************name:" + name);
        return brandDao.getBrands();
    }

    @Override
    public void createBrands(Brand brand) {
        brandDao.createBrands(brand);

    }

    @Override
    public void deleteByName(String name) {
        brandDao.deleteByName(name);
    }

    @Override
    public Integer getAllBrands() {
        return brandDao.getAllBrands();
    }

    @Override
    public List<Brand> getBrandByName(String name) {
        return brandDao.getBrandByName(name);
    }

}
