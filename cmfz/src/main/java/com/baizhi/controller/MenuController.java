package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Menu> queryAll(HttpSession session) {
        System.out.println("请求到达~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*List<Menu> list = menuService.queryAll();
        session.setAttribute("list", list);
        return "redirect:/main/main.jsp";*/
        return menuService.queryAll();
    }
}
