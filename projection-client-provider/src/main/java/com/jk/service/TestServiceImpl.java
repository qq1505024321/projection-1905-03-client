package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.CarMapper;
import com.jk.model.Car;
import com.jk.model.Fufei;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private CarMapper carMapper;

    @Override
    public Map<String, Object> queryCars(Integer page, Integer rows) {
        long total = carMapper.queryTotal();
        int start = (page-1)*rows;
        List<Car> list = carMapper.queryList(start,rows);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public List<Fufei> findFufei() {
        return carMapper.findFufei();
    }
}
