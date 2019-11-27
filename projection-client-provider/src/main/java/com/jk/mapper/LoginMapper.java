package com.jk.mapper;

import com.jk.model.Teacher;
import com.jk.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LoginMapper {
    Users queryUserByName(@Param("un") String username);

    boolean saveUser(Users user);

    void updatePwdByUserNameAndPhoneNumber(@Param("pwd") String password, @Param("pn") String phoneNumber, @Param("un") String userName);


    List<String> selectPowerByUser(@Param("uid") Integer userId, @Param("tid") Integer userType);

    List<Map> findFunctionId();

    int findCount();

    List<Teacher> findUser(@Param("start") Integer start, @Param("rows") Integer rows);

}
