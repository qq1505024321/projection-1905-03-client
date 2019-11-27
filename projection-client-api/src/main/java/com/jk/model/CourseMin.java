package com.jk.model;

import java.io.Serializable;

public class CourseMin implements Serializable {

    private static final long serialVersionUID = 3260340495751570218L;
    private Integer subId;
    private String  subName;

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
        return "CourseMin{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
                '}';
    }
}
