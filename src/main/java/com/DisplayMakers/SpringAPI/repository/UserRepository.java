package com.DisplayMakers.SpringAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DisplayMakers.SpringAPI.model.Users;


public interface UserRepository extends JpaRepository<Users ,Integer> {
    
    Optional<Users> findByLoginAndPassword(String login, String password);
}
