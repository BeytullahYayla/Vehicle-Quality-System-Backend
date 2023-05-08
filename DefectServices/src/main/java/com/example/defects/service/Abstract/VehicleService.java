package com.example.defects.service.Abstract;


import com.example.defects.core.results.DataResult;
import com.example.defects.core.results.Result;
import com.example.defects.domain.Vehicle;

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

    /**
     * Updates an existing vehicle in the system.
     *
     * @param vehicle The user to be updated.
     * @return A Result object indicating the outcome of the operation.
     *         If the vehicle does not exist, returns an ErrorResult with the corresponding message.
     *         If the vehicle is successfully updated, returns a SuccessResult.
     */
    Result update(Vehicle vehicle);


}
