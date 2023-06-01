package com.dxl.mapper;


import com.dxl.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int saveUser(@Param("username") String uname,@Param("password") String password);

    @Select("select uid,username,password from user where username=#{username}")
    User selectByUname(@Param("username") String username);

    @Select("select uid,username,password from user where username=#{username} and password=#{password}")
    User selectByUnamePwd(@Param("username") String username,@Param("password") String password);
}