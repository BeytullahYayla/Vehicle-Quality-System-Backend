package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectDao extends JpaRepository<Defect,Integer> {
}
