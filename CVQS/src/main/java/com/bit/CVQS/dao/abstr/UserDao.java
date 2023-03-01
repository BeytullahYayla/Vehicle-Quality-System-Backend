package com.bit.CVQS.dao.abstr;

import com.bit.CVQS.domain.concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
