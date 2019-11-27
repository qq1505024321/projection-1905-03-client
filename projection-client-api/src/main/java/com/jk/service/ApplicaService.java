package com.jk.service;
import com.jk.model.Applica;
import com.jk.model.CourseMin;
import java.util.List;

public interface ApplicaService {

    void addApplica(Applica applica);

    List<CourseMin> queryCourse();

    void addCourse(CourseMin cou);

    Integer queryCourseId(String subName);
}
