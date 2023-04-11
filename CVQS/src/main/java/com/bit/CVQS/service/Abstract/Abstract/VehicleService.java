package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.Vehicle;

import java.util.List;

public interface VehicleService {
    DataResult<List<Vehicle>> getAll();

    Result add(Vehicle vehicle);
}
