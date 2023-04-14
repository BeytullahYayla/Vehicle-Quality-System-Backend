package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}
