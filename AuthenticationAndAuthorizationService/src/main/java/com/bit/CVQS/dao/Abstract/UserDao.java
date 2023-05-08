package com.bit.CVQS.dao.Abstract;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<com.bit.CVQS.domain.Concrete.User, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.deleted = true WHERE u.userId = :id")
    void softDelete(@Param("id") int id);

    com.bit.CVQS.domain.Concrete.User findUsersByUserName(String userName);
    Boolean existsByUserName(String userName);

}
