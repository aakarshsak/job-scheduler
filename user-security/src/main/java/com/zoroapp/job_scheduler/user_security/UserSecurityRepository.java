package com.zoroapp.job_scheduler.user_security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByUsername(String username);
    Optional<UserEntity> findUserByEmail(String email);
}
