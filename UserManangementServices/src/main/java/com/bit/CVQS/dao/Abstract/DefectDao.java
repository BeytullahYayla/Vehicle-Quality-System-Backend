package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Defect;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefectDao extends JpaRepository<Defect,Integer>, JpaSpecificationExecutor<Defect> {
    Page<Defect> findAllByOrderByDefectNameAsc(Pageable pageable);

    List<Defect>  findAll(Specification<Defect> specification);
    @Transactional
    @Modifying
    @Query("UPDATE Defect d SET d.deleted=true WHERE d.id =:id")
    void softDelete(@Param("id") int id);

}
