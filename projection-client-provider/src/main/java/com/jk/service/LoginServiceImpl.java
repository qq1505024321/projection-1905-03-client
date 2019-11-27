package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.LoginMapper;
import com.jk.model.Teacher;
import com.jk.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author chenchunlan
 * @create 2019/11/14
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Users queryUserByName(String username) {
        return loginMapper.queryUserByName(username);
    }

    @Override
    public boolean saveUser(Users user) {
      /*  // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(user.getUserName());
        *//*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * *//*
        String newPs = new SimpleHash("MD5", user.getPassWord(), salt, 1024).toHex();

        user.setPassWord(newPs);*/
        // 看数据库中是否存在该账户
        Users users = loginMapper.queryUserByName(user.getUserName());
        if(users == null) {
            loginMapper.saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void updatePwdByUserNameAndPhoneNumber(String password, String phoneNumber, String userName) {
        //String newPs = new SimpleHash("MD5", password, ByteSource.Util.bytes(userName), 1024).toHex();
        loginMapper.updatePwdByUserNameAndPhoneNumber(password,phoneNumber,userName);
    }

    @Override
    public List<String> selectPowerByUser(Users userCode) {
        return loginMapper.selectPowerByUser(userCode.getUserId(),userCode.getUserType());
    }

    @Override
    public List<Map> findFunctionId() {
        return loginMapper.findFunctionId();
    }

    @Override
    public Map findUser(Integer rows,Integer page) {
        HashMap<String, Object> result = new HashMap<>();

        int count=loginMapper.findCount();
        result.put("total",count);

        Integer start=(page-1)*rows;
        List<Teacher> list=loginMapper.findUser(start,rows);
        result.put("rows",list);
        return result;
    }


}