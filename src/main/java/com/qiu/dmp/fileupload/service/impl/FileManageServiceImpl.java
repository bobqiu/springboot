package com.qiu.dmp.fileupload.service.impl;


import com.qiu.dmp.fileupload.dao.IFileManageDao;
import com.qiu.dmp.fileupload.service.IFileManageService;
import com.qiu.dmp.model.DataFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Service
public class FileManageServiceImpl implements IFileManageService {

    @Autowired
    private IFileManageDao fileManageDao;

    @Override
    public int insertFile(DataFile dataFile) {

        return fileManageDao.insertFile(dataFile);
    }

    @Override
    public List<DataFile> queryDataFile() {
        return fileManageDao.queryDataFile();
    }

}
