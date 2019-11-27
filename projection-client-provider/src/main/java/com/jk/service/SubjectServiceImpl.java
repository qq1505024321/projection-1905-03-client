package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/20
 * @since 1.0.0
 */
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectMapper subjectMapper;

}