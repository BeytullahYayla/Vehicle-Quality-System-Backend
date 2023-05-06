package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.DefectLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<DefectLocation,Integer> {
}
