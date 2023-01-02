package com.example.demo.dto;

import com.example.demo.model.CustomerType;

public interface ICustomerDto {
    Integer getId();
    String getName();
    String getBirthday();
    Integer getGender();
    String getIdCard();
    String getPhone();
    String getEmail();
    String getAddress();
    String getType();
}
