package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Orders;
import com.jk.model.Users;
import com.jk.service.OrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

   @Reference
    private OrderService orderService;

   @RequestMapping("queryorderList")
   @ResponseBody
   public Map<String, Object> queryorderList(Integer page, Integer rows, Orders orders){
       Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
       Map<String, Object> map = orderService.queryorderList(page, rows, orders,user);
       return map;
   }

   @RequestMapping("toshow")
    public String toshow(){

       return "kechengshow";
   }
    //新增订单
    @RequestMapping("toadd")
    public String add1(){
        return "addorder";
    }
    @RequestMapping("addorder")
    @ResponseBody
    public String addOrder(Orders orders){
        orderService.addOrder(orders);
        return "1";
    }
    @RequestMapping("update")
    @ResponseBody
    public void update(Integer id,Integer status){
       orderService.update(id,status);
    }
}