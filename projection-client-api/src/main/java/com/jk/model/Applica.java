package com.jk.model;

import java.io.Serializable;

public class Applica implements Serializable {
    private static final long serialVersionUID = 2715175869732691675L;

    private Integer     appid;
    private String      teachername;
    private Integer     teacherlevelid;
    private String      shenfenzheng;
    private String      identityimg;
    private String      certification;
    private Integer     appstatus;
    private Integer     courseid;
    private String      teachershow;
    /*临时字段*/
    private String     teacherlevel;
    private String     subname;
    private String     teacherphone;
    private String     teacherimg;
    private String     username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeacherimg() {
        return teacherimg;
    }

    public void setTeacherimg(String teacherimg) {
        this.teacherimg = teacherimg;
    }

    public String getTeacherphone() {
        return teacherphone;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone;
    }

    public String getTeacherlevel() {
        return teacherlevel;
    }

    public void setTeacherlevel(String teacherlevel) {
        this.teacherlevel = teacherlevel;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Integer getTeacherlevelid() {
        return teacherlevelid;
    }

    public void setTeacherlevelid(Integer teacherlevelid) {
        this.teacherlevelid = teacherlevelid;
    }


    public String getIdentityimg() {
        return identityimg;
    }

    public void setIdentityimg(String identityimg) {
        this.identityimg = identityimg;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Integer getAppstatus() {
        return appstatus;
    }

    public void setAppstatus(Integer appstatus) {
        this.appstatus = appstatus;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getTeachershow() {
        return teachershow;
    }

    public void setTeachershow(String teachershow) {
        this.teachershow = teachershow;
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }

    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    @Override
    public String toString() {
        return "Applica{" +
                "appid=" + appid +
                ", teachername='" + teachername + '\'' +
                ", teacherlevelid=" + teacherlevelid +
                ", shenfenzheng='" + shenfenzheng + '\'' +
                ", identityimg='" + identityimg + '\'' +
                ", certification='" + certification + '\'' +
                ", appstatus=" + appstatus +
                ", courseid=" + courseid +
                ", teachershow='" + teachershow + '\'' +
                ", teacherlevel='" + teacherlevel + '\'' +
                ", subname='" + subname + '\'' +
                ", teacherphone='" + teacherphone + '\'' +
                ", teacherimg='" + teacherimg + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
