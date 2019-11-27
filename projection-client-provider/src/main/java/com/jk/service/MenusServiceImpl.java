package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.MenusMapper;
import com.jk.model.Menus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MenusServiceImpl implements MenusService{

    @Autowired
    private MenusMapper menusMapper;

    @Override
    public List<Menus> queryMenuTree(int pid,Integer typeid) {
        List<Menus> menus = menusMapper.queryMenusTree(pid,typeid);
        //递归方法
        if(menus != null && menus.size()>0){
            for (int i = 0; i < menus.size(); i++) {
                List<Menus> menus2 = queryMenuTree(menus.get(i).getId(),typeid);
                menus.get(i).setNodes(menus2);
            }
        }
        return menus;
    }
}
