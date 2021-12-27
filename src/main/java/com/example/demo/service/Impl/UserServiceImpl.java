package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.entity.UserPO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //添加用户
    @Override
    public void addUser(UserPO userPO) {

       userMapper.insert(userPO);

    }

    //删除用户
    @Override
    public boolean delUser(int id) {
        return userMapper.delUser(id);
    }

    //修改用户
    @Override
    public void updateUser(UserPO userPO) {
        userMapper.updateUser(userPO);
    }

    //查询单条用户信息
    @Override
    public UserPO findUser(int id) {
        return userMapper.findUser(id);
    }

    //QueryWrapper查询
    public List<UserPO> getList(String username, Integer roleId) {
        //构建一个查询wrapper
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.isNull(username) && username.length() != 0) {
            wrapper.like(UserPO::getUsername, "%" + username + "%");
        }
        if (!Objects.isNull((roleId))) {
            wrapper.eq(UserPO::getRoleId, roleId);
        }

        return userMapper.selectList(wrapper);
    }

}
