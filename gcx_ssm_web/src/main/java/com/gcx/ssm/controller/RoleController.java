package com.gcx.ssm.controller;

import com.gcx.ssm.domain.Permission;
import com.gcx.ssm.domain.Role;
import com.gcx.ssm.domain.UserInfo;
import com.gcx.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Role> roleList = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(String id, Model model){
        //根据角色id查询角色没有的权限
        List<Permission> permissionList = roleService.findOtherPermission(id);
        model.addAttribute("permissionList", permissionList);
        model.addAttribute("roleId", id);
        return "role-permission-add";
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId, String[] ids, Model model){
        for (int i = 0; i < ids.length; i++) {
            roleService.addPermissionToRole(roleId, ids[i]);
        }
        return "redirect:findAll";
    }

}
