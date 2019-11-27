package com.jk.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="t_advertising")
public class Advertising implements Serializable {
    private static final long serialVersionUID = 7985271750269020942L;

    private String id;
    private String imgname; //  图片名称
    private String bgcolor;  //  图片背景色
    private String company; //  公司名称
    private String imgurl;  //  跳转页面
    private Integer status; //  显示状态  1代表续约 2代表下架广告

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "id='" + id + '\'' +
                ", imgname='" + imgname + '\'' +
                ", bgcolor='" + bgcolor + '\'' +
                ", company='" + company + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", status=" + status +
                '}';
    }
}
