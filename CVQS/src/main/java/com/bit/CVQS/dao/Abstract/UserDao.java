package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findUsersByUserName(String username);

}
