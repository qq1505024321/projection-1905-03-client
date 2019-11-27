package com.jk.model;

import java.io.Serializable;

public class Subject implements Serializable {

    private static final long serialVersionUID = 5016940650012259300L;
    //课程目录详情
    private Integer subjectId;
    //课程目录
    private String  subjectName;

    private String  subjectTime;

    private Integer  courseTypeId;

    private String  staName;

    private String startDate;

    private String endDate;

    private  Integer subId;
    //课程
    private  String subName;


    private String courselevel;
    private String userName;
    private String teacherlevel;
    private String subInfo;
    private String subImg;
    private Integer courselevelid;
    private Integer teacherlevelid;

    public String getSubInfo() {
        return subInfo;
    }

    public void setSubInfo(String subInfo) {
        this.subInfo = subInfo;
    }

    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg;
    }

    public Integer getTeacherlevelid() {
        return teacherlevelid;
    }

    public void setTeacherlevelid(Integer teacherlevelid) {
        this.teacherlevelid = teacherlevelid;
    }

    public Integer getCourselevelid() {
        return courselevelid;
    }

    public void setCourselevelid(Integer courselevelid) {
        this.courselevelid = courselevelid;
    }

    public String getCourselevel() {
        return courselevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeacherlevel() {
        return teacherlevel;
    }

    public void setTeacherlevel(String teacherlevel) {
        this.teacherlevel = teacherlevel;
    }

    public void setCourselevel(String courselevel) {
        this.courselevel = courselevel;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectTime() {
        return subjectTime;
    }

    public void setSubjectTime(String subjectTime) {
        this.subjectTime = subjectTime;
    }

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectTime='" + subjectTime + '\'' +
                ", courseTypeId=" + courseTypeId +
                ", staName='" + staName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", subId=" + subId +
                ", subName='" + subName + '\'' +
                ", courselevel='" + courselevel + '\'' +
                ", userName='" + userName + '\'' +
                ", teacherlevel='" + teacherlevel + '\'' +
                ", subInfo='" + subInfo + '\'' +
                ", subImg='" + subImg + '\'' +
                ", courselevelid=" + courselevelid +
                ", teacherlevelid=" + teacherlevelid +
                '}';
    }
}
