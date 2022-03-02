package com.lqy.mapper;

import com.lqy.poji.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select *from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username")String username,@Param("password") String password);
    User selectByUsername(String username);
    int add(User user);
}
