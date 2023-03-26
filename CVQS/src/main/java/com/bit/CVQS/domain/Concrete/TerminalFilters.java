package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "filters")
public class TerminalFilters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;


    @JsonIgnoreProperties("terminalFilters")
    @ManyToMany(mappedBy = "terminalFilters",fetch = FetchType.LAZY,cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Terminals> terminals;
}
