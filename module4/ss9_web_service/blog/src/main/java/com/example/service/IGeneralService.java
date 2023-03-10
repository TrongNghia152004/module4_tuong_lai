package com.example.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
    Optional<T> findById(int id);
    T save(T t);
    void remove(int id);
}
