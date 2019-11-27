package com.jk.mapper;

import com.jk.model.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {

    long queryTotal(@Param("ss") Schedule schedule);

    List<Schedule> queryorderList(@Param("start") int start, @Param("rows") int rows,@Param("ss") Schedule schedule);

    void addschedule(Schedule schedule);
}
