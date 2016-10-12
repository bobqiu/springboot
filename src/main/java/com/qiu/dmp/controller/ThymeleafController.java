package com.qiu.dmp.controller;


import com.qiu.dmp.model.Brand;
import com.qiu.dmp.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@Controller
public class ThymeleafController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "测试测试");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        List<Brand> brands = brandService.getBrands();
        map.addAttribute("brands", brands);
        map.addAttribute("brand", new Brand());
        return "index";
    }

    @RequestMapping("/nav")
    public String nav(ModelMap model) {
        String renderName = "nav";
        model.addAttribute("name", "测试参数");

        List<String> list = new ArrayList<String>();
        list.add("content_mark1");
       /* list.add("mark2");
        list.add("mark3");*/
        model.addAttribute("marks", list);


        // LOGGER.info("------进入用户信息修改-------");
        return "template/" + renderName;
    }

    @RequestMapping("/p")
    public String navs(@RequestParam String url, ModelMap model) {
        String renderName = "n";
        model.addAttribute("name", "测试参数");

        List<String> list = new ArrayList<String>();
        list.add("content_mark1");
       /* list.add("mark2");
        list.add("mark3");*/
        model.addAttribute("marks", list);
        // LOGGER.info("------进入用户信息修改-------");
        //return "template/" + renderName;
        model.addAttribute("data", "[[0,0,5],[0,1,1],[0,2,0],[0,3,0],[0,4,0],[0,5,0],[0,6,0],[0,7,0],[0,8,0],[0,9,0],[0,10,0],[0,11,2],[0,12,4],[0,13,1],[0,14,1],[0,15,3],[0,16,4],[0,17,6],[0,18,4],[0,19,4],[0,20,3],[0,21,3],[0,22,2],[0,23,5],[1,0,7],[1,1,0],[1,2,0],[1,3,0],[1,4,0],[1,5,0],[1,6,0],[1,7,0],[1,8,0],[1,9,0],[1,10,5],[1,11,2],[1,12,2],[1,13,6],[1,14,9],[1,15,11],[1,16,6],[1,17,7],[1,18,8],[1,19,12],[1,20,5],[1,21,5],[1,22,7],[1,23,2],[2,0,1],[2,1,1],[2,2,0],[2,3,0],[2,4,0],[2,5,0],[2,6,0],[2,7,0],[2,8,0],[2,9,0],[2,10,3],[2,11,2],[2,12,1],[2,13,9],[2,14,8],[2,15,10],[2,16,6],[2,17,5],[2,18,5],[2,19,5],[2,20,7],[2,21,4],[2,22,2],[2,23,4],[3,0,7],[3,1,3],[3,2,0],[3,3,0],[3,4,0],[3,5,0],[3,6,0],[3,7,0],[3,8,1],[3,9,0],[3,10,5],[3,11,4],[3,12,7],[3,13,14],[3,14,13],[3,15,12],[3,16,9],[3,17,5],[3,18,5],[3,19,10],[3,20,6],[3,21,4],[3,22,4],[3,23,1],[4,0,1],[4,1,3],[4,2,0],[4,3,0],[4,4,0],[4,5,1],[4,6,0],[4,7,0],[4,8,0],[4,9,2],[4,10,4],[4,11,4],[4,12,2],[4,13,4],[4,14,4],[4,15,14],[4,16,12],[4,17,1],[4,18,8],[4,19,5],[4,20,3],[4,21,7],[4,22,3],[4,23,0],[5,0,2],[5,1,1],[5,2,0],[5,3,3],[5,4,0],[5,5,0],[5,6,0],[5,7,0],[5,8,2],[5,9,0],[5,10,4],[5,11,1],[5,12,5],[5,13,10],[5,14,5],[5,15,7],[5,16,11],[5,17,6],[5,18,0],[5,19,5],[5,20,3],[5,21,4],[5,22,2],[5,23,0],[6,0,1],[6,1,0],[6,2,0],[6,3,0],[6,4,0],[6,5,0],[6,6,0],[6,7,0],[6,8,0],[6,9,0],[6,10,1],[6,11,0],[6,12,2],[6,13,1],[6,14,3],[6,15,4],[6,16,0],[6,17,0],[6,18,0],[6,19,0],[6,20,1],[6,21,2],[6,22,2],[6,23,6]]");
        return "template/" + url;
    }

    @RequestMapping("/marketing")
    public String marketing(String name, Model model, HttpSession session) {

        // LOGGER.info("------进入用户信息修改-------");
        model.addAttribute("username", "测试名称");
        session.setAttribute("usersession", "session测试111");

        return "marketing";
    }

    @RequestMapping("/hotel")
    public String hotel(String name, Model model, HttpSession session) {

        // LOGGER.info("------进入用户信息修改-------");
        model.addAttribute("username", "测试名称");
        session.setAttribute("usersession", "session测试111");

        return "hotel";
    }


    @RequestMapping("/mvc")
    public String mvc(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "测试测试");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        List<Brand> brands = brandService.getBrands();
        map.addAttribute("brands", brands);
        map.addAttribute("brand", new Brand());
        return "page_timeline";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String post(Brand brand) {
        System.out.println("==============================" + brand.getEname());
        return "redirect:/";
    }

    @RequestMapping("/table")
    public String tableList(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "测试测试");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        List<Brand> brands = brandService.getBrands();
        map.addAttribute("brands", brands);
        map.addAttribute("brand", new Brand());
        return "advancedTable";
    }

}



