package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.ErrorResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.domain.Concrete.User;
import com.bit.CVQS.domain.Concrete.Vehicle;
import com.bit.CVQS.service.Abstract.Abstract.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/Vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getAll")
    public DataResult<List<Vehicle>> getAll(){
        log.debug("Vehicle getAll executed!");
        return this.vehicleService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Vehicle vehicle){
        try{
            this.vehicleService.add(vehicle);
            log.info("Vehicle added successfully");
            return new SuccessResult("Vehicle added successfully");
        }
        catch (Exception e){
            log.error("An error occured while adding vehicle id:"+vehicle.getId());
            return new ErrorResult("An error occured while adding vehicle");
        }

    }
    @PutMapping("/update")
    public Result update(@RequestBody Vehicle vehicle){

        try{
            this.vehicleService.update(vehicle);
            log.info("User updated successfully. User Id: "+vehicle.getId());
            return new SuccessResult("Vehicle updated successfully.");
        }
        catch (Exception e){

            log.error("Error occurred while updating vehicle. Vehicle Id: " + vehicle.getId(), e);
            return new ErrorResult("An error occurred while deleting vehicle");

        }





    }
}
