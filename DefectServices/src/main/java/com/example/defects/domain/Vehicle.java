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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Car")
@SQLDelete(sql="UPDATE Car SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties("vehicle")
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "vehicles")
    List<Defect> defects;

    @Column(name = "deleted")
    private boolean deleted=Boolean.FALSE;


}
