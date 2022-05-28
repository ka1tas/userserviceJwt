package com.kraken.userservice.repository;

import com.kraken.userservice.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findByName(String name);
}
