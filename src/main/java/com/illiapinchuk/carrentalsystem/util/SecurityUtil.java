package com.illiapinchuk.carrentalsystem.util;

import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.model.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static User getAuthorizedUser() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user instanceof UserPrincipal ? ((UserPrincipal) user).user() : null;
    }
}
