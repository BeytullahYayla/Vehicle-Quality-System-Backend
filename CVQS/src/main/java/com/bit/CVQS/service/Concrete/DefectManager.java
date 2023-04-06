package com.bit.CVQS.service.Concrete;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessDataResult;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.dao.Abstract.DefectDao;
import com.bit.CVQS.dao.Abstract.LocationDao;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.DefectLocation;
import com.bit.CVQS.service.Abstract.Abstract.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result add(Defect defect) {
        for(DefectLocation defectLocation:defect.getLocations()){
            if (this.locationDao.findById(defectLocation.getId()).isEmpty()){
                this.locationDao.save(defectLocation);
            }
        }
        this.defactDao.save(defect);



        return new SuccessResult("Defect Added Successfully");
    }
}
