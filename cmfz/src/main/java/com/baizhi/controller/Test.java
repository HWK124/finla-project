package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/8/28.
 */
@Controller
@RequestMapping("test")
public class Test {
    @RequestMapping("test")
    public String test() {
        return "index";
    }
}
