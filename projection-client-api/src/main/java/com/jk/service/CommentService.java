package com.jk.service;

import com.jk.model.Comment;
import com.jk.model.Praise;

import java.util.List;

public interface CommentService {
    //  根据教程id和pid  递归查询所有评论
    List<Comment> queryCommentById(String commentid, String pid);

    //  查询根据 点赞的用户id和被点赞的评论id 查询是否有评论记录
    List<Praise> queryPraise(Integer userid, String id);

    //  新增点赞记录
    void addPraise(Integer userid, String id);

    //  删除点赞记录
    void delPraise(String id);
}
