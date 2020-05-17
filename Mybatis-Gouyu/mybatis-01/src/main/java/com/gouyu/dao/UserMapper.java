package com.gouyu.dao;

import com.gouyu.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //按id查询用户
    User getUserById(int id);

    //新增用户
    int addUser(User user);

    //更新用户
    int updUser(User user);

    //删除用户
    int delUser(int id);
}
