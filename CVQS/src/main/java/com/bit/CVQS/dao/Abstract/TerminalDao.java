package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Terminals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerminalDao extends JpaRepository<Terminals,Integer> {
    public List<Terminals> findByIsActiveTrue();

}
