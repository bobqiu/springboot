package com.qiu.dmp.fileupload.controller;


import com.alibaba.fastjson.JSON;
import com.qiu.dmp.fileupload.service.IFileManageService;
import com.qiu.dmp.model.DataFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Controller
public class FileUploadController {

    @Autowired
    private IFileManageService fileManageService;


    @RequestMapping("/fileupload")
    public String preUpload() {
        return "fileload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("@@@@@@@@@@@@@@@@@@upload:" + file.getOriginalFilename());
        InputStream is = null;
        BufferedReader br = null;
        BufferedOutputStream out = null;
        if (!file.isEmpty()) {
            try {
                long size = file.getSize();
                String path = "d:\\";

                file.transferTo(new File(path + file.getOriginalFilename()));
                // out = new BufferedOutputStream((new FileOutputStream(new File("D:\\"+file.getOriginalFilename()))));
                is = new FileInputStream(new File(path + file.getOriginalFilename()));
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"), 512);
                String head = br.readLine();
                System.out.println("header:" + head);
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    line = line.trim();
                    System.out.println("content:" + line);
                    /*if (!("").equals(line)||line != null) {

                        break;

                    }*/

                }

                DataFile dataFile = new DataFile();
                dataFile.setCreateTime(Timestamp.from(Instant.now()));
                dataFile.setName(file.getOriginalFilename());
                dataFile.setPath(path);
                dataFile.setSize(file.getSize());
                fileManageService.insertFile(dataFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                is.close();
//                out.close();

            }
        }
        return "fileload";
    }


    @RequestMapping(value = "files")
    @ResponseBody
    public String getFileList() {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&777getfileList");
        List<DataFile> dfList = new ArrayList<DataFile>();
        List<DataFile> dataFiles = fileManageService.queryDataFile();
/*
        for (DataFile df : dataFiles) {
            DataFile dataFile = new DataFile();
            dataFile.setName(String.valueOf(df.getCreater()));
            dataFile.setId(df.getCreater());
            dataFile.setCreater(0);
            dataFile.setSize(0);
            dataFile.setLeaf(false);
            dfList.add(dataFile);
        }

       // List<string> listWithoutDup = new ArrayList<string>(new HashSet<string>(listWithDup));
        HashSet hashSet = new HashSet(dfList);
        dfList.clear();
        dfList.addAll(hashSet);

        dfList.addAll(dataFiles);*/

        String json = JSON.toJSONString(dataFiles, true);
        System.out.println(json);
        return json;

    }
}
