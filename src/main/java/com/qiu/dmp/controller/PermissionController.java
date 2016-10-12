package com.qiu.dmp.controller;

import com.alibaba.fastjson.JSON;
import com.qiu.dmp.permission.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 */
@Controller
public class PermissionController {


    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/per", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request) {
        // JSONObject paraJson= JSONObject.fromObject(params);
        System.out.println("##########################" + request.getParameter("id") + ":" + request.getParameter("pid") + ":" + request.getParameter("name"));

        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");

        int i = permissionService.inserPermission(id, pid, name, "");
        System.out.println("&&&&&&&&&&&&&&&&&&" + i);

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(i));
        map.put("code", "1");
        map.put("message", "添加成功");
        String json = JSON.toJSONString(map, true);
        System.out.println(json);
        return json;

    }
}
