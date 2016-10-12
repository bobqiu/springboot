package com.qiu.dmp;

import com.qiu.dmp.model.Brand;
import com.qiu.dmp.service.BrandService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BrandService brandService;

    @Before
    public void setUp() {
        brandService.deleteByName("test");

        Assert.assertEquals(12, brandService.getAllBrands().intValue());

    }

    @Test
    public void test() {
        List<Brand> brands = brandService.getBrands();
        for (Brand brand : brands) {
            System.out.println(brand.toString());
        }

        Brand brand = new Brand();
        brand.setEname("testest测试");
        brandService.createBrands(brand);
        System.out.println("====================================");

        List<Brand> brands1 = brandService.getBrandByName("test");
        for (Brand brand1 : brands1) {
            System.out.println(brand1.toString());
        }
    }
}