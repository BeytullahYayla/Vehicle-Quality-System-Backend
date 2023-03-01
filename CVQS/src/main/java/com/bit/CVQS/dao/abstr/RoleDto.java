package com.bit.CVQS.dao.abstr;

import com.bit.CVQS.domain.concrete.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDto extends JpaRepository<Role,Integer> {
}
