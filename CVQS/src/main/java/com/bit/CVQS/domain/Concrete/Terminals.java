package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "terminals")
@SQLDelete(sql="UPDATE terminals SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Terminals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;


    @Column(name = "deleted")
    private boolean deleted=Boolean.FALSE;


    @JsonIgnoreProperties("terminals")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "terminal_filters",
            joinColumns = @JoinColumn(name = "terminal_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "filter_id",referencedColumnName = "id"))
    public List<TerminalFilter> terminalFilters;







}
