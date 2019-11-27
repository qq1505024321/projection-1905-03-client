package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jk.model.Menus;
import com.jk.model.Users;
import com.jk.service.MenusService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MenusController {
    @Reference
    private MenusService menusService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("queryMenusTree")
    @ResponseBody
    //客户端 自己调用service-dao查询树,存缓存
    public List<Menus> queryMenusTree(){
        Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
        List<Menus> list = null;
        String str = (String) redisTemplate.opsForValue().get("tree_"+user.getUserType());
        if(str!=null){
            list = (List<Menus>) JSON.parse(str);
        }else {
//               调用service查询树
               list = menusService.queryMenuTree(-1,user.getUserType());
//
            redisTemplate.opsForValue().set("tree_"+user.getUserType(), JSONArray.toJSONString(list));

        }
        return  list;
    }
}
