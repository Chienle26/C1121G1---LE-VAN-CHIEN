package com.chienle.repository.user_role;

import com.chienle.model.user_role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
