package com.dice.constructify.user.repository;

import com.dice.constructify.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findOneByEmail(String email);
    Boolean existsByEmail(String email);
}
