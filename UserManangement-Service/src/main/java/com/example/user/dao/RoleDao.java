package com.example.user.dao;


import com.example.user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}
