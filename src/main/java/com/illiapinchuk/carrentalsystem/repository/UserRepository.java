package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user inner join fetch user.roles where user.login = :login")
    User getUserByLogin(String login);

    User getUserByEmail(String email);
}
