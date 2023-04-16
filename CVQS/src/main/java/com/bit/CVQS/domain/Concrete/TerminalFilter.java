package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filters")
public class TerminalFilter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "filter_name")
    private String name;

    @JsonIgnoreProperties("terminalFilters")
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "terminalFilters")
    public List<Terminals> terminals;




}
