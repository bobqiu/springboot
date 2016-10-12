package com.qiu.dmp.fileupload.dao;


import com.qiu.dmp.model.DataFile;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public interface IFileManageDao {

    public int insertFile(DataFile dataFile);

    public List<DataFile> queryDataFile();

}
