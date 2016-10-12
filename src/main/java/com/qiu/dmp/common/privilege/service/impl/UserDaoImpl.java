package com.qiu.dmp.common.privilege.service.impl;

import com.qiu.dmp.common.privilege.service.IUserDao;
import com.qiu.dmp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/31.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findUserByName(String loginName) {

        String sql = "select * from user where user_name=?";

        User user = jdbcTemplate.queryForObject(sql, new Object[]{loginName}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        // User user = jdbcTemplate.queryForObject(sql, new Object[]{loginName}, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    public Set<String> findRoles(String loginName) {
        List<String> list = new ArrayList<String>();
        String sql = "SELECT r.role_name FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id where u.user_name=?";

        list = jdbcTemplate.query(sql, new Object[]{loginName}, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String role_name = rs.getString("role_name");
                return role_name;
            }
        });

        Set<String> set = new HashSet<String>(list);
        return set;
    }

    @Override
    public Set<String> findPermissions(String loginName) {
        List<String> list = new ArrayList<String>();
        String sql = "SELECT res.permission FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id JOIN role_permission rr ON r.role_id = rr.role_id JOIN permission res ON rr.permission_id = res.permission_id where u.user_name=?";

        list = jdbcTemplate.query(sql, new Object[]{loginName}, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String permission = rs.getString("permission");
                return permission;
            }
        });

        Set<String> set = new HashSet<String>(list);
        return set;
    }

    //@Select("SELECT res.permission FROM sys_user u JOIN sys_user_role ur ON u.id = ur.user_id JOIN sys_role r ON ur.role_id = r.id JOIN sys_role_resource rr ON r.id = rr.role_id JOIN sys_resource res ON rr.resource_id = res.id where u.username=#{username}")
}
