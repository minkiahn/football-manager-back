package com.mkahn.mkahn.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);
    Optional<User> findByNickName(String nickName);
    Optional<User> findByUserEmailAndStatus(String userEmail, String status);
}