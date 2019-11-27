package com.jk.controller;

import com.jk.model.Advertising;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("advertising")
@Controller
public class AdvertisingController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("queryAdvertising")
    @ResponseBody
    public List<Advertising> queryAdvertising(){
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(1));

        List<Advertising> list = mongoTemplate.find(query,Advertising.class);
        return list;
    }

    @RequestMapping("addAdvertising")
    @ResponseBody
    public void add(){
        Advertising adv = new Advertising();
        adv.setImgname("gg1.jpg");
        adv.setBgcolor("#76abba");
        adv.setCompany("长城汽车WEY公司");
        adv.setImgurl("https://www.wey.com/");
        adv.setStatus(1);
        mongoTemplate.save(adv);
    }


}
