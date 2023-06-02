package com.example.defects.dao.Abstract;

import com.example.defects.domain.DefectLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<DefectLocation,Integer> {
}
