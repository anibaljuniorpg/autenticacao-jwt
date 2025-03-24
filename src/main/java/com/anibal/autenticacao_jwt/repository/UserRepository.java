package com.anibal.autenticacao_jwt.repository;

import com.anibal.autenticacao_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
