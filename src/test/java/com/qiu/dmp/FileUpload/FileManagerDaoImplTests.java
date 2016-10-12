package com.qiu.dmp.FileUpload;

import com.qiu.dmp.fileupload.dao.IFileManageDao;
import com.qiu.dmp.model.DataFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileManagerDaoImplTests {
    @Autowired
    private IFileManageDao fileManagerDao;

    @Test
    public void insertDataFile() {
        DataFile dataFile = new DataFile();
        dataFile.setCreateTime(Timestamp.from(Instant.now()));
        dataFile.setName("test.csv");
        dataFile.setPath("d:\\");
        dataFile.setSize(345);
        int i = fileManagerDao.insertFile(dataFile);
        // Assert.assertArrayEquals(1, i);

    }

    @Test
    public void listDataFile() {

        List<DataFile> dataFiles = fileManagerDao.queryDataFile();

        for (DataFile dataFile : dataFiles) {
            System.out.println(dataFile.toString());

        }

    }
}
