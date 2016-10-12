package com.qiu.dmp.dao.impl;


import com.qiu.dmp.dao.BrandDao;
import com.qiu.dmp.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@Service
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Brand> getBrands() {
        //return jdbcTemplate.queryForList("select * from brand", Brand.class);
        return jdbcTemplate.query("select * from brand", new RowMapper<Brand>() {
            @Override
            public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
                Brand brand = new Brand();
                brand.setId(rs.getInt("id"));
                brand.setName(rs.getString("name"));
                brand.setEname(rs.getString("ename"));
                brand.setSource(rs.getString("source"));
                brand.setALIAS(rs.getString("ALIAS"));
                brand.setSite(rs.getString("site"));

                return brand;
            }
        });
    }

    @Override
    public void createBrands(Brand brand) {
        jdbcTemplate.update("INSERT INTO brand(name) VALUES (?)", brand.getEname());

    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM brand where id>500");
    }

    @Override
    public Integer getAllBrands() {
        return jdbcTemplate.queryForObject("select count(1) from brand", Integer.class);
    }

    @Override
    public List<Brand> getBrandByName(String name) {
        return jdbcTemplate.queryForList("SELECT  * from brand where id<?", new Object[]{name}, Brand.class);
    }
}

