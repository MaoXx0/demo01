package com.demo.mapper;

import com.demo.pojo.UserLogin;
import org.apache.ibatis.annotations.Param;

public interface LoginRegisterMapper {
    UserLogin findByUsername(@Param("username") String username);
    Integer registerToTable(@Param("username")String username,@Param("password")String password);
}
