package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.MyOrderMapper;
import com.jk.model.Orders;
import com.jk.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/21
 * @since 1.0.0
 */
@Service
public class MyOrderServiceImpl implements MyOrderService{

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Override
    public JSONObject queryMyOrder(Integer page, Integer rows, Orders orders, Users user) {
        long total = myOrderMapper.getCount3(orders,user.getUserId());
        Integer start = (page-1)*rows;
        JSONObject json = new JSONObject();
        List<Orders> bookList = myOrderMapper.queryMyOrderByUser(orders,start,rows,user.getUserId());
        json.put("total", total);
        json.put("rows", bookList);
        return json;
    }

    @Override
    public void editUser(Users users) {
        myOrderMapper.editUser(users);
    }
}