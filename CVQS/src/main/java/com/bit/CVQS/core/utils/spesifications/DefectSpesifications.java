package com.bit.CVQS.core.utils.spesifications;

import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.Vehicle;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DefectSpesifications {
    public static Specification<Defect> search(String keyword) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("defectName")), "%" + keyword.toLowerCase() + "%"));
            Join<Defect, Vehicle> vehicleJoin = root.join("vehicles");
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(vehicleJoin.get("name")), "%" + keyword.toLowerCase() + "%"));
            Join<Defect, Location> locationJoin = root.join("locations");
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(locationJoin.get("name")), "%" + keyword.toLowerCase() + "%"));
            return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
