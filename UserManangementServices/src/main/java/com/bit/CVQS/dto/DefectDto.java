package com.bit.CVQS.dto;

import com.bit.CVQS.domain.Concrete.DefectLocation;
import com.bit.CVQS.domain.Concrete.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefectDto {
    private int id;
    private String defectName;
    private List<VehicleDto> vehicles;
    private List<DefectLocationDto> defectLocations;
    private  Boolean deleted;

}
