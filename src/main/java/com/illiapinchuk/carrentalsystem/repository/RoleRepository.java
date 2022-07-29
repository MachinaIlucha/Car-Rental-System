package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.Role;
import com.illiapinchuk.carrentalsystem.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(RoleName roleName);
}
