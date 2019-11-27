package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈、〉
 *
 * @author chenchunlan
 * @create 2019/11/14
 * @since 1.0.0
 */
public class Users implements Serializable {

    private static final long serialVersionUID = -445094983768048305L;


    //主键id
    private Integer userId;
    //用户名
    private String userName;
    //用户密码 MD5加密
    private String passWord;
    //用户手机号码
    private String phoneNumber;
    //用户类型    1 =学生 ； 2= 教师
    private Integer userType;



    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                '}';
    }
}