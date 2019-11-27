package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.ApplicaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @ClassName PageController
 * @Description TODO
 * @Author rhy
 * @Date 2019/11/15 16:53
 **/
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toaddApplica")
    public String toaddApplica(){
        return "teacherApplica";
    }
}
