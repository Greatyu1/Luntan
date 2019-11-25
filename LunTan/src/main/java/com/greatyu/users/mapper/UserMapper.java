package com.greatyu.users.mapper;

import com.greatyu.users.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("UserMapper")
public interface UserMapper {
    List<User> listUser(@Param("user") User user);

    User login(@Param("username") String username,@Param("password") String password);
}
