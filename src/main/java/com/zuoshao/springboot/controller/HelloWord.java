package com.zuoshao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zuoshao
 * @date 2019/3/10 - 16:49
 */
@Controller
public class HelloWord {
    @RequestMapping("/hello")
    public String hello()
    {
        return "login";
    }
    @RequestMapping("/shuxing")
    public String hello22()
    {
        return "shuxingtest";
    }
}
