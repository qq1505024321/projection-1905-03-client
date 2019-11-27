package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.OrderMapper;
import com.jk.model.Orders;
import com.jk.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Map<String, Object> queryorderList(Integer page, Integer rows, Orders orders, Users user) {
        long total = orderMapper.queryTotal(orders,user.getUserId());
        int start = (page-1)*rows;
        List<Orders> list = orderMapper.queryorderList(start,rows,orders,user.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public void addOrder(Orders orders) {
        long num = new Date().getTime();
        int suijishu = (int) (Math.random() * (89999) + 10000);
        String no = String.valueOf(num) + String.valueOf(suijishu);
        long orderNumber = (long) JSONObject.parse(no);
        orders.setOrderNumber(orderNumber);
        orderMapper.addOrder(orders);
    }

    @Override
    public void update(Integer id, Integer status) {
        orderMapper.update(id,status);
    }


}
