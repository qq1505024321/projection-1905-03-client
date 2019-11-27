package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Menus implements Serializable {

    private static final long serialVersionUID = 4751971472263434658L;
    private Integer id;

    private String text;

    private String href;

    private Integer pid;

    private List<Menus> nodes;

    //用户类型    1 =学生 ； 2= 教师
    private Integer userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menus> getNodes() {
        return nodes;
    }

    public void setNodes(List<Menus> nodes) {
        this.nodes = nodes;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", nodes=" + nodes +
                '}';
    }
}
