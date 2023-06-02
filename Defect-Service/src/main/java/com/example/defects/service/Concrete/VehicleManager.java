package com.example.defects.service.Concrete;


import com.example.defects.core.results.*;
import com.example.defects.dao.Abstract.VehicleDao;
import com.example.defects.domain.Vehicle;
import com.example.defects.service.Abstract.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleManager implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;


    @Override
    public DataResult<List<Vehicle>> getAll() {
        return new SuccessDataResult<>(this.vehicleDao.findAll());
    }



    @Override
    public Result add(Vehicle vehicle) {
        this.vehicleDao.save(vehicle);
        return new SuccessResult("Vehicle Added Successfully");
    }
    @Override
    public Result update(Vehicle vehicle) {
        if(this.vehicleDao.findById(vehicle.getId()).isEmpty()){
            return new ErrorResult("Vehicle Doesn't Exist");
        }
        else{
            this.vehicleDao.save(vehicle);
            return new SuccessResult("Vehicle Updated Successfully");
        }

    }


}
