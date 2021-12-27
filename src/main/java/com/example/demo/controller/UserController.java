package com.example.demo.controller;


import com.example.demo.entity.UserPO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping(value = "/add")
    public boolean addUser( @RequestBody UserPO userPO){
         userService.addUser(userPO);
         return true;
    }

    //删除用户
    @DeleteMapping(value = "del/{id}")
    public boolean delUser(@PathVariable Integer id){
        return userService.delUser(id);
    }

    //修改用户
    @PostMapping(value = "/update")
    public boolean updateUser(@RequestBody UserPO userPO){
        userService.updateUser(userPO);
        return true;
    }

    //查询单条用户信息
    @GetMapping(value = "/One/{id}")
    public UserPO findUser(@PathVariable Integer id){
        return userService.findUser(id);
    }

    //QueryWrapper查询
    @GetMapping(value = "/query")
    public Map<String,Object> getList(@RequestParam(required=false)  String username,@RequestParam(required = false) Integer roleId){
        Map<String,Object> result = new HashMap<>();
        List<UserPO> list=userService.getList(username,roleId);
        result.put("data",list);
        return  result;
    }



}
