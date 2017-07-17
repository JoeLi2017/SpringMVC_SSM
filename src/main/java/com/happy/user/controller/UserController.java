package com.happy.user.controller;

import com.happy.user.model.User;
import com.happy.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lirongbo on 2017/7/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String showUser(HttpServletRequest request, Model model){
        logger.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "user/list";
    }

}
