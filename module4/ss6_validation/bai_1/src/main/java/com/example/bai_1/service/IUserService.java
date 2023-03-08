package com.example.bai_1.service;

import com.example.bai_1.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);
}
