package com.gcx.ssm.controller;

import com.gcx.ssm.domain.UserInfo;
import com.gcx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<UserInfo> userInfoList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String addUser(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public String findById(String id, Model model){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user", userInfo);
        return "user-show";
    }
}
