package com.demo.mapper;

import com.demo.pojo.AddEmployee;
import com.demo.pojo.ModifyEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    Integer addEmployee(@Param("id")Integer id, @Param("username")String username, @Param("age")Integer age,
                        @Param("birthday")String birthday,@Param("email")String email,@Param("address")String address);

    AddEmployee findByUsername(@Param("username")String username);

    AddEmployee findById(@Param("id")Integer id);

    Integer modifyEmployee(@Param("id")Integer id, @Param("username")String username, @Param("age")Integer age,
                        @Param("birthday")String birthday,@Param("email")String email,@Param("address")String address);

    Integer deleteEmployee(@Param("id")Integer id);

    List<AddEmployee> getAllEmployee();

}
