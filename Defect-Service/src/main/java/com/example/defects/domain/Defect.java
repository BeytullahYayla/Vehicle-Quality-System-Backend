package com.example.defects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "defects")
@SQLDelete(sql="UPDATE defects SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Defect {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "name")
    private String defectName;

    @Column(name = "deleted")
    private boolean deleted=Boolean.FALSE;

    @JsonIgnoreProperties("defects")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicle_defect",
            joinColumns = @JoinColumn(name = "defect_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id",referencedColumnName = "id"))
    public List<Vehicle> vehicles;

    @JsonIgnoreProperties("defects")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "defect_defectLocation",
            joinColumns = @JoinColumn(name = "defect_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "defect_location_id",referencedColumnName = "id"))
    public List<DefectLocation> locations;

}
