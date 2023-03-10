package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.service.impl.IUserService;

import java.util.List;

public class UserService implements IUserService {
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
