package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.Vehicle;

import java.util.List;

public interface VehicleService {
    /**
     * Retrieves all vehicles from the system.
     *
     * @return A DataResult object containing a list of vehicles.
     *         If the retrieval is successful, returns a SuccessDataResult with the vehicle list.
     *         Otherwise, returns an ErrorDataResult.
     */
    DataResult<List<Vehicle>> getAll();
    /**
     * Adds a new vehicle to the system.
     *
     * @param vehicle The vehicle object to be added.
     * @return A Result object indicating the status of the operation.
     *         If the vehicle is successfully added, returns a SuccessResult.
     *         Otherwise, returns an ErrorResult.
     */

    Result add(Vehicle vehicle);
}
