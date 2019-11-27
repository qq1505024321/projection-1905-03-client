package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Orders;
import com.jk.model.Users;
import com.jk.service.MyOrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("myOrder")
public class MyOrderController {

    @Reference
    private MyOrderService myOrderService;

    @RequestMapping("toMyOrder")
    public String toMyOrder(){
       /* Object username = SecurityUtils.getSubject().getSession().getAttribute("login");
        Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
        System.out.println(username+"++++++++++++++");
        System.out.println(user+"==============="+username);
*/
        return "myOrder";
    }

    @RequestMapping("queryMyOrder")
    @ResponseBody
    public JSONObject queryMyOrder(Integer page, Integer rows, Orders orders){
        // Object username = SecurityUtils.getSubject().getSession().getAttribute("login");
        Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
        System.out.println(user+"===============");
        return myOrderService.queryMyOrder(page,rows,orders,user);
    }
    //修改个人信息
    @RequestMapping("toEditUser")
    public String toEditUser(){
        // System.out.println("---------------1");
        return "editUser";
    }

    @RequestMapping("editUser")
    public String editUser(Users users){
        //  System.out.println(users+"'''''''''''''''");
        myOrderService.editUser(users);
        //修改完之后再将修改后的信息存到session中
        SecurityUtils.getSubject().getSession().setAttribute("userObj", users);
        // System.out.printf(users+"0000000000000000000");
        //  Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
        return "zhifuyemian";
    }

}