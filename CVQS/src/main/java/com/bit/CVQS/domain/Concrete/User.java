package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;
    @JsonIgnoreProperties("users")
    @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id",
                            nullable = false, updatable = false)})


    public List<Role> roles;

}