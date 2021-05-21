package com.example.demo.repository;

import com.example.demo.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserData, String> {
    List<UserData> findAll();
}
