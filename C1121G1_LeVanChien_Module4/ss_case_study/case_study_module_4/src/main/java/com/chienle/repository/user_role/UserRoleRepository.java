package com.chienle.repository.user_role;

import com.chienle.model.user_role.User;
import com.chienle.model.user_role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(User user);
}
