package com.bit.CVQS.service.Concrete;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessDataResult;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.dao.Abstract.VehicleDao;
import com.bit.CVQS.domain.Concrete.Vehicle;
import com.bit.CVQS.service.Abstract.Abstract.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleManager implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Override
    public DataResult<List<Vehicle>> getAll() {
        return new SuccessDataResult<List<Vehicle>>(this.vehicleDao.findAll());
    }

    @Override
    public Result add(Vehicle vehicle) {
        this.vehicleDao.save(vehicle);
        return new SuccessResult("Vehicle Added Successfully");
    }
}
