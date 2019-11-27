package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {

    private static final long serialVersionUID = 4105776238730975517L;

    private Integer id;
    private String claname;
    private String img;
    private String teacher;
    private Double claprice;
    private Date starttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Double getClaprice() {
        return claprice;
    }

    public void setClaprice(Double claprice) {
        this.claprice = claprice;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", claname='" + claname + '\'' +
                ", img='" + img + '\'' +
                ", teacher='" + teacher + '\'' +
                ", claprice=" + claprice +
                ", starttime=" + starttime +
                '}';
    }
}
