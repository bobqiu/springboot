package com.qiu.dmp.fileupload.dao.impl;

import com.qiu.dmp.fileupload.dao.IFileManageDao;
import com.qiu.dmp.model.DataFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Repository
public class FileManageDaoImpl implements IFileManageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertFile(DataFile dataFile) {
        final String sql = "insert into DATA_FILE(NAME, PATH, SIZE ,CREATE_TIME) value(?,?,?,?)";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, dataFile.getName());
                ps.setString(2, dataFile.getPath());
                ps.setLong(3, dataFile.getSize());
                ps.setTimestamp(4, dataFile.getCreateTime());
            }
        });
    }

    @Override
    public List<DataFile> queryDataFile() {
        final String sql = "SELECT  ID,NAME ,PATH,SIZE,CREATE_TIME,CREATER FROM DATA_FILE";

        return jdbcTemplate.query(sql, new RowMapper<DataFile>() {

            @Override
            public DataFile mapRow(ResultSet rs, int rowNum) throws SQLException {
                DataFile dataFile = new DataFile();
                dataFile.setCreateTime(rs.getTimestamp("CREATE_TIME"));
                dataFile.setId(rs.getInt("ID"));
                dataFile.setName(rs.getString("NAME"));
                dataFile.setPath(rs.getString("PATH"));
                dataFile.setSize(rs.getLong("SIZE"));
                dataFile.setCreater(rs.getInt("CREATER"));

                return dataFile;
            }
        });
    }
}
