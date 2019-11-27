package com.jk.model;

import java.io.Serializable;

public class Teacher implements Serializable {

    private static final long serialVersionUID = -6904141585429347676L;
    private Integer appid;
    private String  teachername;
    private Integer teacherlevelid;
    private String  shenfenzheng;
    private String  identityimg;
    private String  certification;
    private Integer appstatus;
    private String  createtime;
    private Integer courseid;
    private String  teachershow;
    private String  teacherphone;
    private String  teacherimg;
    private String  username;

    public Integer getAppid() {
        return appid;
    }

    public String getTeachername() {
        return teachername;
    }

    public Integer getTeacherlevelid() {
        return teacherlevelid;
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }

    public String getIdentityimg() {
        return identityimg;
    }

    public String getCertification() {
        return certification;
    }

    public Integer getAppstatus() {
        return appstatus;
    }

    public String getCreatetime() {
        return createtime;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public String getTeachershow() {
        return teachershow;
    }

    public String getTeacherphone() {
        return teacherphone;
    }

    public String getTeacherimg() {
        return teacherimg;
    }

    public String getUsername() {
        return username;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setTeacherlevelid(Integer teacherlevelid) {
        this.teacherlevelid = teacherlevelid;
    }

    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    public void setIdentityimg(String identityimg) {
        this.identityimg = identityimg;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setAppstatus(Integer appstatus) {
        this.appstatus = appstatus;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public void setTeachershow(String teachershow) {
        this.teachershow = teachershow;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone;
    }

    public void setTeacherimg(String teacherimg) {
        this.teacherimg = teacherimg;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "appid=" + appid +
                ", teachername='" + teachername + '\'' +
                ", teacherlevelid=" + teacherlevelid +
                ", shenfenzheng='" + shenfenzheng + '\'' +
                ", identityimg='" + identityimg + '\'' +
                ", certification='" + certification + '\'' +
                ", appstatus=" + appstatus +
                ", createtime='" + createtime + '\'' +
                ", courseid=" + courseid +
                ", teachershow='" + teachershow + '\'' +
                ", teacherphone='" + teacherphone + '\'' +
                ", teacherimg='" + teacherimg + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
