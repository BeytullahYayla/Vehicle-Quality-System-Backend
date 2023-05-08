package com.example.terminal.dao.Abstract;

import com.example.terminal.domain.Concrete.Terminals;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TerminalDao extends JpaRepository<Terminals,Integer> {
    List<Terminals> findByIsActiveTrue();
    @Transactional
    @Modifying
    @Query("UPDATE Terminals t SET t.deleted = true WHERE t.id = :id")
    void softDelete(@Param("id") int id);


}
