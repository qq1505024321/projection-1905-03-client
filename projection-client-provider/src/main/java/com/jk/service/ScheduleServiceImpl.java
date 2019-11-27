package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ScheduleMapper;
import com.jk.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public Map<String, Object> queryscheduleList(int page,int rows,Schedule schedule) {
        long total = scheduleMapper.queryTotal(schedule);
        int start = (page-1)*rows;
        List<Schedule> list = scheduleMapper.queryorderList(start,rows,schedule);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public void addschedule(Schedule schedule) {
        scheduleMapper.addschedule(schedule);
    }
}
