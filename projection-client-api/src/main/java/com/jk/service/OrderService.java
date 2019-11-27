package com.jk.service;

import com.jk.model.Orders;
import com.jk.model.Users;

import java.util.Map;

public interface OrderService {


    Map<String, Object> queryorderList(Integer page, Integer rows, Orders orders, Users user);

    void addOrder(Orders orders);

    void update(Integer id, Integer status);
}
