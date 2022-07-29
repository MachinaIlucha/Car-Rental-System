package com.illiapinchuk.carrentalsystem.config;

import com.illiapinchuk.carrentalsystem.model.Role;
import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(username);

        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            Set<Role> userRoles = user.getRoles();
            for (Role ur : userRoles)
                authorities.add(new SimpleGrantedAuthority("ROLE_" + ur.getRoleName()));

            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                    authorities);
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
