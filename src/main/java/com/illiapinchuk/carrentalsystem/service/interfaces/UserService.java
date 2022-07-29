package com.illiapinchuk.carrentalsystem.service.interfaces;

import com.illiapinchuk.carrentalsystem.dto.UserRegistrationDto;
import com.illiapinchuk.carrentalsystem.exception.EmailExistsException;
import com.illiapinchuk.carrentalsystem.exception.LoginExistsException;
import com.illiapinchuk.carrentalsystem.model.RoleName;
import com.illiapinchuk.carrentalsystem.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByLogin(String login);

    User addUser(UserRegistrationDto user) throws EmailExistsException, LoginExistsException;

    User updateUser(User userToUpdate);

    void addRoleToUser(Long userId, RoleName role);
}
