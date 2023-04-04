package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "defect_location")
public class DefectLocation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "x")
    private String x;

    @Column(name = "y")
    private String y;

    @JsonIgnoreProperties("defectLocation")
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "locations")
    public List<Defect> defects;


}
