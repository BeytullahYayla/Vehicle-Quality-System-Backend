package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "defects")
public class Defect {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "name")
    private String defectName;

    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    public Car car;

    @JsonIgnore
    @OneToMany(mappedBy = "defect")
    @MapsId("defectLocationId")
    public List<DefectLocation> locations;
}
