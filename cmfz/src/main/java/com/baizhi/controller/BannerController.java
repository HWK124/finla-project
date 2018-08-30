package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/queryAll")
    @ResponseBody
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public List<Banner> queryAll() {
        return bannerService.queryAll();
    }

    @RequestMapping("/add")
    public void add(Banner banner) {
        System.out.println("add请求到达~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        bannerService.add(banner);
    }

    @RequestMapping("/delete")
    public void delete(Banner banner) {
        bannerService.delete(banner);
    }
}
