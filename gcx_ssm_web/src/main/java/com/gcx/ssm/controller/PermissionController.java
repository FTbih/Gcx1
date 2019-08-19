package com.gcx.ssm.controller;

import com.gcx.ssm.domain.Permission;
import com.gcx.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";

    }
}
