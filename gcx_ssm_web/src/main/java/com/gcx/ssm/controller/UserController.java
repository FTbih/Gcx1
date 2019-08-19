package com.gcx.ssm.controller;

import com.gcx.ssm.domain.Role;
import com.gcx.ssm.domain.UserInfo;
import com.gcx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RolesAllowed("OG")
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

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id, Model model){
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = userService.findOtherRoleById(id);
        model.addAttribute("user", userInfo);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids, Model model){
        //将ids中的数据添加到userId对应的user表中


        for (int i = 0; i < ids.length; i++) {
            userService.addRoleToUser(userId, ids[i]);
        }
        UserInfo userInfo = userService.findById(userId);

        model.addAttribute("user", userInfo);
        return "user-show";
    }


}
