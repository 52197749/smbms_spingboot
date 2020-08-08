package com.yjl.controller;

import com.yjl.pojo.User;
import com.yjl.service.user.UserService;
import com.yjl.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 2020/6/18.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return  "../../login";
    }


    @RequestMapping("/frame.do")
    public String frame(){
        // WEB-INF/jsp/frame.jsp
        return "frame";
    }

    @RequestMapping("/login.do")
    public String login(@RequestParam("userCode") String userCode,
                        @RequestParam("userPassword") String password,
                        HttpSession session,
                        Model model) throws Exception {

        User user = userService.login(userCode, password);
        //判断用户是否登录
        if(user != null){
            session.setAttribute(Constants.USER_SESSION, user);
            //跳转到后台首页
            //WEB-INF/jsp/frame.jsp
            return "redirect:/frame.do";
        }else{
            //用户为空，抛出异常，跳转到错误页面，显示错误信息
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
