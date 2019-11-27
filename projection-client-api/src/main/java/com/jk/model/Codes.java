package com.jk.model;

import com.alibaba.com.caucho.hessian.io.Deserializer;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/17
 * @since 1.0.0
 */
public class Codes implements Serializable {

    private static final long serialVersionUID = 5673355396694234668L;

    private String mobile;
    private String obj;
    private String msg;

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getObj() {
        return obj;
    }
    public void setObj(String obj) {
        this.obj = obj;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}