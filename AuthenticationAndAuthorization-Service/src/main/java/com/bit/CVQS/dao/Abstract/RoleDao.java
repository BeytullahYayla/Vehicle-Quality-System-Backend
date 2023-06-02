package com.bit.CVQS.dao.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<com.bit.CVQS.domain.Concrete.Role,Integer> {
    Optional<com.bit.CVQS.domain.Concrete.Role> findByName(String name);
}
