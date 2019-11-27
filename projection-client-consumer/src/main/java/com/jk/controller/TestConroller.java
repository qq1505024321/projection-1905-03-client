package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.model.Fufei;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestConroller {
    @Reference
    private TestService testService;


    @RequestMapping("findFufei")
    public String findFufei(HttpServletRequest request, Model model){
        List<Fufei> list=testService.findFufei();
        model.addAttribute("list",list);
        return "fufei";
    }

    @RequestMapping("topinglun")
    public String topinglun(){
        return "pinglun";
    }

    @RequestMapping("tomulu")
    public String tomulu(){
        return "mulu";
    }

    @RequestMapping("tokecheng")
    public String tokecheng(){
        return "kecheng";
    }


    @RequestMapping("tofufei")
    public String tofufei(){
        return "fufei";
    }

    @RequestMapping("tomain")
    public String tomain(){

        return "main";
    }

    @RequestMapping("tovideo")
    public String tovideo(){

        return "video";
    }

    @RequestMapping("tovideo2")
    public String tovideo2(){

        return "video2";
    }

    @RequestMapping("queryCars")
    @ResponseBody
    public Map<String, Object> queryCars (Integer page, Integer rows) {
        Map<String, Object> map = testService.queryCars(page,rows);
        return map;
    }



}
