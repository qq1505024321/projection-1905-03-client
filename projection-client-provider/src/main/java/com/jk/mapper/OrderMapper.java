package com.jk.mapper;

import com.jk.model.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    long queryTotal(@Param("oo")Orders orders,@Param("userId") Integer userId);

    List<Orders> queryorderList(@Param("start")int start, @Param("rows")Integer rows,@Param("oo")Orders orders,@Param("userId") Integer userId);

    void addOrder(Orders orders);

    void update(@Param("id") Integer id, @Param("status") Integer status);
}
