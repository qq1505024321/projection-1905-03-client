package com.jk.service;

import com.jk.model.Menus;

import java.util.List;

public interface MenusService {
    List<Menus> queryMenuTree(int pid,Integer typeid);
}
