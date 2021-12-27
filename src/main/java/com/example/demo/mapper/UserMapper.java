package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
   //添加用户
   @Insert("insert into user(username,password,roleId,roleDesc) values(#{username},#{password},#{role_id},#{role_desc})")
   void addUser(UserPO userPO);

   //删除用户
   @Delete("delete from user where id=#{id}")
   boolean delUser(int id);

   //修改用户
   @Update(" update user set username=#{username},password=#{password},roleId=#{roleId},roleDesc=#{roleDesc} where id=#{id}")
   boolean updateUser(UserPO userPO);

   //查询单条用户信息
   @Select({" select * from user where id=#{id}"})
   UserPO findUser(int id);

}
