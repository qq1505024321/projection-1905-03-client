package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Orders;
import com.jk.model.Users;

public interface MyOrderService {
    JSONObject queryMyOrder(Integer page, Integer rows, Orders orders, Users user);

    void editUser(Users users);
}
