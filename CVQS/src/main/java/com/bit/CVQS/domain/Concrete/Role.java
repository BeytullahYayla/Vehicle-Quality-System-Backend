package com.bit.CVQS.domain.Concrete;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int Id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties("roles")
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER,cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    //Cascade, bir varlık nesnesinde yapılacak değişikliklerin, ilişkili varlık nesnelerine de yansıtılmasını sağlayan bir özelliktir.

    public List<User> users;
}
