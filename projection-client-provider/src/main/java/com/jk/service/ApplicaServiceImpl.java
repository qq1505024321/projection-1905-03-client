package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ApplicaMapper;
import com.jk.model.Applica;
import com.jk.model.CourseMin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ApplicaServiceImpl implements ApplicaService {
    @Autowired
    private ApplicaMapper applicaMapper;

    @Override
    public void addApplica(Applica applica) {
        applicaMapper.addApplica(applica);
    }

    @Override
    public List<CourseMin> queryCourse() {
        return applicaMapper.queryCourse();
    }

    @Override
    public void addCourse(CourseMin cou) {
        applicaMapper.addCourse(cou);
    }

    @Override
    public Integer queryCourseId(String subName) {
        return applicaMapper.queryCourseId(subName);
    }
}
