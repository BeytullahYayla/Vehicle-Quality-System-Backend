package com.bit.CVQS.dto;

import com.bit.CVQS.domain.Concrete.Defect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleDto {

    private int id;
    private String name;
    private List<DefectDto> defects;
    public Boolean deleted;

}
