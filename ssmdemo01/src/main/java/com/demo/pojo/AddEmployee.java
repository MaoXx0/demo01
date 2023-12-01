package com.demo.pojo;

import lombok.Data;


@Data
public class AddEmployee {
    private Integer id;
    private String username;
    private Integer age;
    private String birthday;
    private String email;
    private String address;
}
