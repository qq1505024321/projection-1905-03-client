package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Fufei;
import com.jk.model.Schedule;
import com.jk.service.ScheduleService;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("schedule")
public class ScheduleController {

    @Reference
    private ScheduleService scheduleService;

    @RequestMapping("queryscheduleList")
    @ResponseBody
    public Map<String, Object> queryscheduleList(int page, int rows,Schedule schedule){
        Map<String, Object> map = scheduleService.queryscheduleList(page,rows,schedule);
        return map;
    }

    @RequestMapping("toscheduleshow")
    public String toscheduleshow(){
        return "scheduleshow";
    }

   /* @RequestMapping("toadd")
    public String toadd(){
        return "addschedule";
    }*/

    @RequestMapping("addschedule1")
    @ResponseBody
    public String addschedule(Schedule schedule, HttpServletRequest request){
        List<Fufei> list = (List<Fufei>) request.getSession().getAttribute("list");
            for(int i=0;i<list.size();i++){

            }
        scheduleService.addschedule(schedule);
        return "1";
    }
}
