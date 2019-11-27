package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sha")
public class shaxiang {

    @RequestMapping("xiang")
    public String xiang(){

        return "list";
    }
    @RequestMapping("haha")
    public String haha(){
        return "fanhui";
    }
    @RequestMapping("qukecheng")
    public String qukecheng(){
        return "kecheng";
    }

    @RequestMapping("tozhifuyemian")
    public String tozhifuyemian(){
        return "zhifuyemian";
    }

    @RequestMapping("toceshi1")
    public String toceshi1(){
        return "ceshi";
    }
}
