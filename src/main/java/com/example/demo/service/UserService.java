package com.example.demo.service;

import com.example.demo.entity.UserPO;
import java.util.List;

public interface UserService  {
    //添加用户
    void addUser(UserPO user);

    //删除用户
    boolean delUser(int id);

    //修改用户
    void updateUser(UserPO userPO);

    //查询单条用户信息
    UserPO findUser(int id);

    //QueryWrapper查询
    List<UserPO> getList(String username,Integer roleId);

}
