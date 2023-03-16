package com.example.repository;

import com.example.model.LevelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelEmployeeRepository extends JpaRepository<LevelEmployee,Integer> {
    LevelEmployee findLevelEmployeeByName(String name);
}
