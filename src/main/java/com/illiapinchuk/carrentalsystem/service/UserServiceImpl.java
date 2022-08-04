package com.illiapinchuk.carrentalsystem.service;

import com.illiapinchuk.carrentalsystem.dto.UserRegistrationDto;
import com.illiapinchuk.carrentalsystem.exception.EmailExistsException;
import com.illiapinchuk.carrentalsystem.exception.LoginExistsException;
import com.illiapinchuk.carrentalsystem.model.RoleName;
import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.model.UserPrincipal;
import com.illiapinchuk.carrentalsystem.repository.RoleRepository;
import com.illiapinchuk.carrentalsystem.repository.UserRepository;
import com.illiapinchuk.carrentalsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    @Transactional
    public User addUser(UserRegistrationDto userDto) throws EmailExistsException, LoginExistsException {
        if (checkLoginExists(userDto.getLogin())) throw new LoginExistsException();
        if (checkEmailExists(userDto.getEmail())) throw new EmailExistsException();

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPesel(userDto.getPesel());
        user.setRoles(Collections.singleton(roleRepository.findRoleByRoleName(RoleName.CUSTOMER)));

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

    @Override
    public void addRoleToUser(Long userId, RoleName role) {
        User user = userRepository.getReferenceById(userId);
        user.getRoles().add(roleRepository.findRoleByRoleName(role));
        userRepository.save(user);
    }

    public boolean checkLoginExists(String login) {
        return userRepository.getUserByLogin(login) != null;
    }

    public boolean checkEmailExists(String email) {
        return userRepository.getUserByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.getUserByEmail(username));
    }
}
