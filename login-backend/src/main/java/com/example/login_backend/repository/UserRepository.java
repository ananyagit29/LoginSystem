package com.example.login_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login_backend.entity.DmsUser;

public interface UserRepository extends JpaRepository<DmsUser, String> {
}