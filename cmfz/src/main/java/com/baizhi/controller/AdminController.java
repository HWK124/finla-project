package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/8/28.
 */
@Controller
@RequestMapping
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(String userName, String password) {
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);

        if (adminService.login(admin) != null) {
            return "";
        } else {
            return "";
        }

    }
}
