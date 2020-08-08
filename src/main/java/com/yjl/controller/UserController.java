package com.yjl.controller;

import com.yjl.pojo.Role;
import com.yjl.service.role.RoleService;
import com.yjl.service.user.UserService;
import com.yjl.utils.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * Created by Hunter on 2020-05-22.
 */
@RequestMapping("/user")
@Controller
public class UserController {



    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;



    @RequestMapping("/list")
    public String userlist(@RequestParam(value = "queryname", required = false) String userName,
                           @RequestParam(value = "queryUserRole", required = false)Integer roleId,
                           @RequestParam(value = "pageIndex", required = false)Integer pageIndex,
                           Model model) throws Exception {
        PageSupport pageSupport = new PageSupport();
        if(pageIndex != null){
            pageSupport.setCurrentPageNo(pageIndex);
        }
        if(roleId==null){
            roleId = 0;
        }
        userService.getUsersPage(pageSupport, userName, roleId);

        //查询角色列表
        List<Role> roleList = roleService.getRoleList();

        //把数据返回给页面
        model.addAttribute("userList", pageSupport.getList());
        model.addAttribute("totalPageCount", pageSupport.getTotalPageCount());
        model.addAttribute("totalCount", pageSupport.getTotalCount());
        model.addAttribute("currentPageNo", pageSupport.getCurrentPageNo());
        //把角色列表放入model
        model.addAttribute("roleList", roleList);
        //把用户名和角色id返回给页面回显
        model.addAttribute("queryUserName", userName);
        model.addAttribute("queryUserRole", roleId);


        // /WEB-INF/jsp/  xxx   .jsp
        return "user/userlist";
    }


}
