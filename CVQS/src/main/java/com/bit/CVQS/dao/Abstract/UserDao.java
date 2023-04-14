package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findUsersByUserName(String userName);
    Boolean existsByUserName(String userName);

}
