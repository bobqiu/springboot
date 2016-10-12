package com.qiu.dmp.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Administrator on 2016/10/8.
 */
public class StringUtils {

    private static final Logger log = Logger.getLogger(StringUtils.class);

    public static String TempFileInstance(String filePath, String original, String replaced) throws IOException {
        log.debug("filePath:" + filePath + " original:" + original + " replaced:" + replaced);
        FileInputStream fis = null;
        String s2 = new String();
        try {
            File file1 = new File(filePath);
            fis = new FileInputStream(file1);
            StringWriter writer = new StringWriter();
            IOUtils.copy(fis, writer, "UTF-8");
            String s1 = writer.toString();
            s2 = s1.replaceAll(original, replaced);
            System.out.println("s2=:" + s2);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
        return s2;
    }

    public static void StringWriteToFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        FileWriter fw = new FileWriter(file);
        // fw.write(content);

        IOUtils.write(content, fw);
        fw.flush();
    }
}