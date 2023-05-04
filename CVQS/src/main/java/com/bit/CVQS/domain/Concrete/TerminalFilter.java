package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filters")
@SQLDelete(sql="UPDATE filters SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class TerminalFilter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "filter_name")
    private String name;

    @Column(name = "deleted")
    private boolean deleted=Boolean.FALSE;

    @JsonIgnoreProperties("terminalFilters")
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "terminalFilters")
    public List<Terminals> terminals;




}
