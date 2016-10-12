package com.qiu.dmp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/8/12.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "this is a boot test too";
    }
}
