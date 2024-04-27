package com.example.day4post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4post.model.User;

public interface Repository extends JpaRepository<User,Integer>
{
    Optional<User> findByEmail(String username);
}

