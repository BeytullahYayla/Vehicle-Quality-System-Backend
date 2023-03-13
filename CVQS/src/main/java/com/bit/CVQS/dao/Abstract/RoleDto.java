package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDto extends JpaRepository<Role,Integer> {
}
