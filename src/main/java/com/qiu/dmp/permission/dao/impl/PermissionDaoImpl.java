package com.qiu.dmp.permission.dao.impl;


import com.qiu.dmp.model.Dept;
import com.qiu.dmp.permission.dao.IPermissionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
@Repository
public class PermissionDaoImpl implements IPermissionDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(PermissionDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int inserPermission(String id, String pid, String name, String note) {
        System.out.println("###########id:" + id + " pid:" + pid + " name:" + name + " note:" + note);

       /* StringBuffer sb = new StringBuffer();
        sb.append("insert into pr_dept(PARENT_ID,DEPT_NAME,CREATE_TIME,NOTE) values(?,?,?,?)");
        LOGGER.debug("PermissionDaoImpl:inserPermission SQL:" + sb.toString());
        int i= jdbcTemplate.update(sb.toString(), new Object[]{pid,name,new Date(),note});
        return i;*/
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                String[] strs = new String[]{"PARENT_ID", "DEPT_NAME", "CREATE_TIME", "NOTE"};
                PreparedStatement ps = con.prepareStatement("insert into pr_dept(PARENT_ID,DEPT_NAME,CREATE_TIME,NOTE) values(?,?,now(),?)", strs);
                ps.setInt(1, Integer.parseInt(pid));
                ps.setString(2, name);
                //  ps.setTimestamp(3, Timestamp.from(Instant.now()));
                ps.setString(3, note);
                return ps;
            }

        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Dept> listPermission(String id) {
        return null;
    }

    @Override
    public int updatePermission(String id) {
        return 0;
    }

    @Override
    public int deletePermission(String id) {
        return 0;
    }
}