package com.example.defects.dto;

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
