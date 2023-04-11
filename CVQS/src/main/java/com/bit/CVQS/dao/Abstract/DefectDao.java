package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Defect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefectDao extends JpaRepository<Defect,Integer>, JpaSpecificationExecutor<Defect> {
    Page<Defect> findAllByOrderByDefectNameAsc(Pageable pageable);

    List<Defect>  findAll(Specification<Defect> specification);
}
