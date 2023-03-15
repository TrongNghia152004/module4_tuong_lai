package com.example.service.impl;

import com.example.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);
}
