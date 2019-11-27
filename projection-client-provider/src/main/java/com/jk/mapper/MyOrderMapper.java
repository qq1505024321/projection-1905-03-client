package com.jk.mapper;

import com.jk.model.Orders;
import com.jk.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyOrderMapper {
    long getCount3(@Param("orders") Orders orders, @Param("userId")Integer userId);

    List<Orders> queryMyOrderByUser(@Param("orders")Orders orders, @Param("start")Integer start, @Param("rows")Integer rows, @Param("userId")Integer userId);

    void editUser(Users users);
}
