package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/18
 * @since 1.0.0
 */
public class Powers implements Serializable {

    private static final long serialVersionUID = 1002977091611208038L;

    private Integer Iid;

    private String text;

    private String href;

    private Integer pid;

    public Integer getIid() {
        return Iid;
    }

    public void setIid(Integer iid) {
        Iid = iid;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Powers{" +
                "Iid=" + Iid +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                '}';
    }
}