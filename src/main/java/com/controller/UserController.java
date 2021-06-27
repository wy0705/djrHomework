package com.controller;

import com.entity.User;
import com.servive.UserServiceImpl;
import com.support.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String name,String password){
        User user=new User();
        if (user==null||user.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign= JWTUtil.sign(user,60L * 1000L * 30L);
        return "hello"+user.getName()+"token:"+sign;
    }

    @RequestMapping(value = "logon",method = RequestMethod.POST)
    @ResponseBody
    public String logon(String username,String password,String gender){
        if (username==null||password==null){
            return "用户名和密码不能为空";
        }
        User user=new User(username,password,gender);
        userService.insertUser(user);
        return user.getName()+"添加成功";
    }

    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String registry(User user) {
        boolean register = userService.register(user);
        if (register) {
            return "hello" + user.getName();
        }
        return "注册失败";
    }
}
