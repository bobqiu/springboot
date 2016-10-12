package com.qiu.dmp.page.service.impl;

import com.qiu.dmp.page.service.IPageService;
import com.qiu.dmp.utils.MultiSequenceInputStream;
import com.qiu.dmp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/30.
 */
@Service
public class PageServiceImpl implements IPageService {


    @Value("${tempPath}")
    private String tempPath = "D:\\project\\springboot\\src\\main\\resources\\public";

    /**
     * @param id
     */
    @Override
    public void makePage(String id) throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("D:\\project\\springboot\\src\\main\\resources\\public\\template\\n.html"));

        File file1 = new File("D:\\project\\springboot\\src\\main\\resources\\public\\template\\n1.html");

        FileInputStream fis1 = new FileInputStream(file1);

        File file2 = new File("D:\\project\\springboot\\src\\main\\resources\\public\\template\\n2.html");
        FileInputStream fis2 = new FileInputStream(file2);


        List<InputStream> list = new ArrayList<InputStream>();
        list.add(fis1);
        list.add(fis2);
        // String s="<div th:fragemnt=\"test\">";
        InputStream is = new MultiSequenceInputStream(list);
        //InputStream is = new SequenceInputStream(fis1, fis2);

        byte[] arr = new byte[1024 * 20];
        int len = 0;
        String s = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\"\n" +
                "      xmlns:layout=\"http://www.ultraq.net.nz/web/thymeleaf/layout\"  layout:decorate=\"~{layout_test}\">";
        fos.write(s.getBytes());
        while ((len = is.read(arr)) != -1) {
            fos.write(arr, 0, len);
            fos.flush();

        }
        String send = "</html>";
        fos.write(send.getBytes());
        fos.flush();
        is.close();
        fos.close();

        fis1.close();
        fis2.close();

    }

    @Override
    public void makePage2(String id) throws IOException {
        String head = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\"\n" +
                "      xmlns:layout=\"http://www.ultraq.net.nz/web/thymeleaf/layout\"  layout:decorate=\"~{layout_test}\">";
        String end = "</html>";

        FileOutputStream fos = new FileOutputStream(new File(tempPath + "\\template\\n.html"));

        String s1 = StringUtils.TempFileInstance(tempPath + "\\component\\chart\\bar.html", "#instanceId#", "11");

        //String s2 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\heatmap.js", "#instanceId#","11");
        String s2 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\mapchinadatarange.html", "#instanceId#", "12");

        String s3 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\radar.html", "#instanceId#", "13");

        String s4 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\dynamicbar.html", "#instanceId#", "14");

        String s5 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\heatmapcartesian.html", "#instanceId#", "15");

        String s6 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\scatter.html", "#instanceId#", "16");

        String s7 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\line.html", "#instanceId#", "17");

        String s8 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\mixzoom.html", "#instanceId#", "18");

        String s9 = StringUtils.TempFileInstance("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\geolines.html", "#instanceId#", "19");


        StringBuilder sb = new StringBuilder(4096);
        sb.append(head);
        sb.append("<div layout:fragment=\"content_mark1\">");
        sb.append(s1);
        sb.append("\n");
        /*sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark2\">");
        sb.append(s2);
        sb.append("\n");
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark3\">");
        sb.append(s3);
        sb.append("\n");
        /*sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark4\">");
        sb.append(s4);
        sb.append("\n");
       /* sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");


        sb.append("<div layout:fragment=\"content_mark5\">");
        sb.append(s5);
        sb.append("\n");
        /*sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");


        sb.append("<div layout:fragment=\"content_mark6\">");
        sb.append(s6);
        sb.append("\n");
        /*sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark7\">");
        sb.append(s7);
        sb.append("\n");
       /* sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark8\">");
        sb.append(s8);
        sb.append("\n");
       /* sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append("<div layout:fragment=\"content_mark9\">");
        sb.append(s9);
        sb.append("\n");
        /*sb.append(" <script th:inline=\"javascript\"  type=\"text/javascript\">");
        sb.append(s2);
        sb.append("</script>");*/
        sb.append("</div>");

        sb.append(end);

        System.out.println("s1+s2:" + sb.toString());

        StringUtils.StringWriteToFile(tempPath + "\\template\\nn.html", sb.toString());
        //StringUtils.StringWriteToFile("D:\\project\\springboot\\src\\main\\resources\\public\\component\\chart\\heatmap_11.js",s2);

    }

    public static void main(String[] args) throws IOException {
        PageServiceImpl psi = new PageServiceImpl();
        psi.makePage2("1");

    }


}
