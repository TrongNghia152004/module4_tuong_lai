package com.example.repository;

import com.example.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends CrudRepository<Province,Long> {
}
