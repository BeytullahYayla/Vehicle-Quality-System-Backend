package com.example.defects.service.Concrete;

import com.example.defects.core.results.DataResult;
import com.example.defects.core.results.Result;
import com.example.defects.core.results.SuccessDataResult;
import com.example.defects.core.results.SuccessResult;
import com.example.defects.core.spesifications.DefectSpesifications;
import com.example.defects.dao.Abstract.DefectDao;
import com.example.defects.dao.Abstract.LocationDao;
import com.example.defects.domain.Defect;
import com.example.defects.domain.DefectLocation;
import com.example.defects.service.Abstract.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DefectManager implements DefectService {
    @Autowired
    private DefectDao defactDao;

    @Autowired
    private LocationDao locationDao;





    @Override
    public DataResult<List<Defect>> getAllDefects() {
        return new SuccessDataResult<List<Defect>>(this.defactDao.findAll(),"Defects Listed");
    }




    @Override
    public DataResult<Page<Defect>> getAllDefectsByPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return new SuccessDataResult<Page<Defect>>(this.defactDao.findAll(pageable));
    }





    @Override
    public DataResult<Page<Defect>> getAllDefectsWithSortedPagination(int pageNumber, int pageSize, String sortBy,String keyword) {
        Pageable pageable=PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Specification<Defect> specification=Specification.where(null);
        if (keyword != null && !keyword.isEmpty()) {
            specification = specification.and(DefectSpesifications.search(keyword));
        }
        Page<Defect> pagedResult=defactDao.findAllByOrderByDefectNameAsc(pageable);
        return new SuccessDataResult<Page<Defect>>(pagedResult);
    }

    @Override
    public DataResult<List<Defect>> getAllDefectsWithFilter(String searchKeyword) {
        Specification<Defect> spec=DefectSpesifications.search(searchKeyword);
        return new SuccessDataResult<List<Defect>>(this.defactDao.findAll(spec));

    }

    @Override
    public Result add(Defect defect) {
        for(DefectLocation defectLocation:defect.getLocations()){
            if (this.locationDao.findById(defectLocation.getId()).isEmpty()){
                this.locationDao.save(defectLocation);
            }
        }
        this.defactDao.save(defect);



        return new SuccessResult("Defect Added Successfully");
    }

    @Override
    public Result delete(int id) {
        this.defactDao.softDelete(id);

        return new SuccessResult("Defect Deleted Successfully");
    }
}
