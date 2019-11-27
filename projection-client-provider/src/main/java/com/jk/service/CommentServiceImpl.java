package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.model.Comment;
import com.jk.model.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Comment> queryCommentById(String commentid,String pid) {
        Query query = new Query();

        if (commentid!=null && !"".equals(commentid)) {
            query.addCriteria(Criteria.where("commentid").is(commentid));
        }
        if (pid!=null && !"".equals(pid)) {
            query.addCriteria(Criteria.where("commentpid").is(pid));
        }
        long zongshu = mongoTemplate.count(query, Comment.class);

        List<Comment> list = mongoTemplate.find(query, Comment.class);
        return list;
    }

    @Override
    public List<Praise> queryPraise(Integer userid, String id) {
        String usid = userid.toString();
        Query query = new Query();
        if (usid!=null && !"".equals(usid)) {
            query.addCriteria(Criteria.where("usid").is(usid));
        }
        if (id!=null && !"".equals(id)) {
            query.addCriteria(Criteria.where("coid").is(id));
        }

        List<Praise> list = mongoTemplate.find(query, Praise.class);
        return list;
    }

    @Override
    public void addPraise(Integer userid, String id) {
        Praise dz = new Praise();
        dz.setUsid(userid.toString());
        dz.setCoid(id);
        mongoTemplate.save(dz);
    }

    @Override
    public void delPraise(String id) {
        Praise dz = new Praise();
        dz.setId(id);
        mongoTemplate.remove(dz);
    }


}
