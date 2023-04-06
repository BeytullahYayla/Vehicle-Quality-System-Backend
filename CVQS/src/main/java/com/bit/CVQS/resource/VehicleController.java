package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Vehicle;
import com.bit.CVQS.service.Abstract.Abstract.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getAll")
    public DataResult<List<Vehicle>> getAll(){
        return this.vehicleService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Vehicle vehicle){
        return this.vehicleService.add(vehicle);
    }
}
