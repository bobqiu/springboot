package com.qiu.dmp.controller;


import com.alibaba.fastjson.JSON;
import com.qiu.dmp.model.CityTemp;
import com.qiu.dmp.model.echart.Series;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2016/8/25.
 */
@Controller
public class DmpController {
    @RequestMapping("/test")
    public String test(ModelMap map) {

        List<CityTemp> list = new LinkedList<CityTemp>();
        CityTemp ct1 = new CityTemp();
        ct1.setName("鄂尔多斯");
        ct1.setValue(12);
        list.add(ct1);

        CityTemp ct2 = new CityTemp();
        ct2.setName("湖州");
        ct2.setValue(20);
        list.add(ct2);

        CityTemp ct3 = new CityTemp();
        ct3.setName("上海");
        ct3.setValue(32);
        list.add(ct3);

        CityTemp ct4 = new CityTemp();
        ct4.setName("齐齐哈尔");
        ct4.setValue(32);
        list.add(ct4);

        /*JSONArray jsonArray = new JSONArray(list);*/
        //String json = JSONArray.toJSONString(list, true);
        JSONArray jsonArray = JSONArray.fromObject(list);

        map.addAttribute("json", jsonArray);
        map.addAttribute("range", "[[119.72,34.85],[119.68,34.85],[119.5,34.84],[119.19,34.77],[118.76,34.63],[118.6,34.6],[118.46,34.6],[118.33,34.57],[118.05,34.56],[117.6,34.56],[117.41,34.56],[117.25,34.56],[117.11,34.56],[117.02,34.56],[117,34.56],[116.94,34.56],[116.94,34.55],[116.9,34.5],[116.88,34.44],[116.88,34.37],[116.88,34.33],[116.88,34.24],[116.92,34.15],[116.98,34.09],[117.05,34.06],[117.19,33.96],[117.29,33.9],[117.43,33.8],[117.49,33.75],[117.54,33.68],[117.6,33.65],[117.62,33.61],[117.64,33.59],[117.68,33.58],[117.7,33.52],[117.74,33.5],[117.74,33.46],[117.8,33.44],[117.82,33.41],[117.86,33.37],[117.9,33.3],[117.9,33.28],[117.9,33.27],[118.09,32.97],[118.21,32.7],[118.29,32.56],[118.31,32.5],[118.35,32.46],[118.35,32.42],[118.35,32.36],[118.35,32.34],[118.37,32.24],[118.37,32.14],[118.37,32.09],[118.44,32.05],[118.46,32.01],[118.54,31.98],[118.6,31.93],[118.68,31.86],[118.72,31.8],[118.74,31.78],[118.76,31.74],[118.78,31.7],[118.82,31.64],[118.82,31.62],[118.86,31.58],[118.86,31.55],[118.88,31.54],[118.88,31.52],[118.9,31.51],[118.91,31.48],[118.93,31.43],[118.95,31.4],[118.97,31.39],[118.97,31.37],[118.97,31.34],[118.97,31.27],[118.97,31.21],[118.97,31.17],[118.97,31.12],[118.97,31.02],[118.97,30.93],[118.97,30.87],[118.97,30.85],[118.95,30.8],[118.95,30.77],[118.95,30.76],[118.93,30.7],[118.91,30.63],[118.91,30.61],[118.91,30.6],[118.9,30.6],[118.88,30.54],[118.88,30.51],[118.86,30.51],[118.86,30.46],[118.72,30.18],[118.68,30.1],[118.66,30.07],[118.62,29.91],[118.56,29.73],[118.52,29.63],[118.48,29.51],[118.44,29.42],[118.44,29.32],[118.43,29.19],[118.43,29.14],[118.43,29.08],[118.44,29.05],[118.46,29.05],[118.6,28.95],[118.64,28.94],[119.07,28.51],[119.25,28.41],[119.36,28.28],[119.46,28.19],[119.54,28.13],[119.66,28.03],[119.78,28],[119.87,27.94],[120.03,27.86],[120.17,27.79],[120.23,27.76],[120.3,27.72],[120.42,27.66],[120.52,27.64],[120.58,27.63],[120.64,27.63],[120.77,27.63],[120.89,27.61],[120.97,27.6],[121.07,27.59],[121.15,27.59],[121.28,27.59],[121.38,27.61],[121.56,27.73],[121.73,27.89],[122.03,28.2],[122.3,28.5],[122.46,28.72],[122.5,28.77],[122.54,28.82],[122.56,28.82],[122.58,28.85],[122.6,28.86],[122.61,28.91],[122.71,29.02],[122.73,29.08],[122.93,29.44],[122.99,29.54],[123.03,29.66],[123.05,29.73],[123.16,29.92],[123.24,30.02],[123.28,30.13],[123.32,30.29],[123.36,30.36],[123.36,30.55],[123.36,30.74],[123.36,31.05],[123.36,31.14],[123.36,31.26],[123.38,31.42],[123.46,31.74],[123.48,31.83],[123.48,31.95],[123.46,32.09],[123.34,32.25],[123.22,32.39],[123.12,32.46],[123.07,32.48],[123.05,32.49],[122.97,32.53],[122.91,32.59],[122.83,32.81],[122.77,32.87],[122.71,32.9],[122.56,32.97],[122.38,33.05],[122.3,33.12],[122.26,33.15],[122.22,33.21],[122.22,33.3],[122.22,33.39],[122.18,33.44],[122.07,33.56],[121.99,33.69],[121.89,33.78],[121.69,34.02],[121.66,34.05],[121.64,34.08]]");

        System.out.println(jsonArray);

        return "test";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public String ajax() {
        List<CityTemp> list = new LinkedList<CityTemp>();
        CityTemp ct1 = new CityTemp();
        ct1.setName("杭州");
        ct1.setValue(12);
        list.add(ct1);

        CityTemp ct2 = new CityTemp();
        ct2.setName("苏州");
        ct2.setValue(20);
        list.add(ct2);

        CityTemp ct3 = new CityTemp();
        ct3.setName("武汉");
        ct3.setValue(32);
        list.add(ct3);

        CityTemp ct4 = new CityTemp();
        ct4.setName("济南");
        ct4.setValue(32);
        list.add(ct4);


      /*  JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        System.out.println(jsonArray.toString());

        return jsonArray.toString();*/
        String json = JSON.toJSONString(list, true);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/profile")
    public String mail() {
        return "profile_test";
    }

    @RequestMapping(value = "/echart/data", method = RequestMethod.POST)
    @ResponseBody
    public String getData() {

        List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"利润21", "支出21", "收入21"}));//数据分组

        List<String> category = new ArrayList<String>(Arrays.asList(new String[]{"周一1", "周二1", "周三1", "周四1", "周五1", "周六1", "周日1"}));//横坐标

        List<Series> series = new ArrayList<Series>();//纵坐标

        series.add(new Series("利润21", "line",
                new ArrayList<Integer>(Arrays.asList(
                        400, 470, 440, 444, 400, 420, 310))));
        series.add(new Series("支出21", "bar",
                new ArrayList<Integer>(Arrays.asList(
                        320, 302, 341, 374, 390, 450, 420))));
        series.add(new Series("收入21", "line",
                new ArrayList<Integer>(Arrays.asList(
                        -120, -132, -101, -134, -190, -230, -210))));

        Map map = new HashMap();
        map.put("title", "测试");
        map.put("legend", legend);
        map.put("category", category);
        map.put("series", series);

        List list = new ArrayList<>();
        list.add(map);


      /*  JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        System.out.println(jsonArray.toString());

        return jsonArray.toString();*/
      /*  String json = JSON.toJSONString(list, true);
        System.out.println(json);*/
        String json = JSON.toJSONString(map, true);
        return json;
    }


    @RequestMapping(value = "/echart/data_map", method = RequestMethod.POST)
    @ResponseBody
    public String getDataMap() {

        List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"iphone311", "iphone4", "iphone5"}));//数据分组

        // List<String> category = new ArrayList<String>(Arrays.asList(new String []{"周一1","周二1","周三1","周四1","周五1","周六1","周日1"}));//横坐标

        List<Series> series = new ArrayList<Series>();//纵坐标

        series.add(new Series("利润21", "line",
                new ArrayList<Integer>(Arrays.asList(
                        400, 470, 440, 444, 400, 420, 310))));
        series.add(new Series("支出21", "line",
                new ArrayList<Integer>(Arrays.asList(
                        320, 302, 341, 374, 390, 450, 420))));
        series.add(new Series("收入21", "line",
                new ArrayList<Integer>(Arrays.asList(
                        -120, -132, -101, -134, -190, -230, -210))));

        Map map = new HashMap();
        map.put("title", "测试");
        map.put("legend", legend);
        // map.put("category", category);
        map.put("series", series);

        List list = new ArrayList<>();
        list.add(map);


        String json = JSON.toJSONString(map, true);
        return json;
    }
}
