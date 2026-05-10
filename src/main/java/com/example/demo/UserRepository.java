package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // jwt 로그인 시 사용자 아이디로 찾는 기능 필요
    User findByUsername(String username);
}