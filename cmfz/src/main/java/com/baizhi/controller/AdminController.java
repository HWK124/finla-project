package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/8/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, String clientCode, HttpSession session) {

        //取出随机验证码
        String serverCode = (String) session.getAttribute("serverCode");
        if (serverCode.equalsIgnoreCase(clientCode)) {
            if (adminService.login(admin) != null) return "redirect:/menu/queryAll";
        }
        return "login";
    }
}
