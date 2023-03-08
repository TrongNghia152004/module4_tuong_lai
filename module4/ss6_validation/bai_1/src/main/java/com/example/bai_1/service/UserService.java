package com.example.bai_1.service;

import com.example.bai_1.model.User;
import com.example.bai_1.repository.IUserRepository;

import java.util.List;

public class UserService implements IUserService{
private IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }
}
