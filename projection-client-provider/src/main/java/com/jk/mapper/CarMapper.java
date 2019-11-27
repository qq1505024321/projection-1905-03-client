package com.jk.mapper;

import com.jk.model.Car;
import com.jk.model.Fufei;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    long queryTotal();

    List<Car> queryList(@Param("start") int start, @Param("rows")Integer rows);
    List<Fufei> findFufei();
}