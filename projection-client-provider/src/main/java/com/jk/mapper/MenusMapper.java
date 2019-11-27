package com.jk.mapper;

import com.jk.model.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenusMapper {
    List<Menus> queryMenusTree(@Param("pid") int pid,@Param("typeid") Integer typeid);
}
