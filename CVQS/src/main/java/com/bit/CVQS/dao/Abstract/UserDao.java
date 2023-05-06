package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.deleted = true WHERE u.userId = :id")
    void softDelete(@Param("id") int id);

    User findUsersByUserName(String userName);
    Boolean existsByUserName(String userName);

}
