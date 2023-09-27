package com.example.secureapplication.repo;

import com.example.secureapplication.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
