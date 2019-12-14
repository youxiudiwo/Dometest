package com.zuoshao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/3/12 - 17:47
 */
@Controller
public class LoginController {

    @PostMapping(value = "/logines")
    public String login(@RequestParam("name") String username,
                        @RequestParam("password") String password
                        , Map<String,Object> map, HttpSession session)
    {
        System.out.println(username+password);
        if (!StringUtils.isEmpty(username) && "123456".equals(password))
        {
            //登录成功重定向到
            System.out.println("开始进行判断");
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else {
            map.put("mag","登录失败请重新输入");
            return "login";
        }
    }

}
