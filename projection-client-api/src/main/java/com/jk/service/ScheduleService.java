package com.jk.service;

import com.jk.model.Schedule;

import java.util.List;
import java.util.Map;

public interface ScheduleService {


    Map<String, Object> queryscheduleList(int page, int rows, Schedule schedule);

    void addschedule(Schedule schedule);
}
