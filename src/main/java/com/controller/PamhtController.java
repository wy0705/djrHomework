package com.controller;

import com.entity.User;
import com.servive.PamhtServiceImpl;
import com.servive.UserServiceImpl;
import com.support.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PamhtController {
    @Autowired
    private PamhtServiceImpl pamhtService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "test",method = RequestMethod.POST)
    @ResponseBody
    public String test(String[] test){
        int scores=0;
        for (int i = 0; i < test.length; i++) {
            scores=scores+pamhtService.findByNamePamht(test[i]).getScore();
        }
        if (scores<60){
            return "没有达到健康的标准，注意保持身心健康！";
        }
        return "今天达到标准了哟！";
    }
}
