package com.example.terminal.dao.Abstract;


import com.example.terminal.domain.Concrete.TerminalFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalFilterDao extends JpaRepository<TerminalFilter,Integer> {
}
