package com.chienle.repository.user_role;

import com.chienle.model.user_role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String name);
}
