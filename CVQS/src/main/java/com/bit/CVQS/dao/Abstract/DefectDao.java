package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Defect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectDao extends JpaRepository<Defect,Integer> {
    Page<Defect> findAllByOrderByDefectNameAsc(Pageable pageable);
}
