package com.jk.model;

import java.io.Serializable;

public class Fufei implements Serializable {
    private static final long serialVersionUID = -6904144865729347676L;
    private Integer id;
    private String  name;
    private Integer count;
    private String  appraise;
    private String  type;
    private String  starttime;
    private String  endtime;
    private Double  price;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public String getAppraise() {
        return appraise;
    }

    public String getType() {
        return type;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fufei{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", appraise='" + appraise + '\'' +
                ", type='" + type + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", price=" + price +
                '}';
    }
}
