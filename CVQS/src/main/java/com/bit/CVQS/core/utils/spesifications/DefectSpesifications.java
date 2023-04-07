package com.bit.CVQS.core.utils.spesifications;

import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.DefectLocation;
import com.bit.CVQS.domain.Concrete.Vehicle;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DefectSpesifications {
    public static Specification<Defect> search(String keyword) {
        return (root, query, cb) -> {
            String likeKeyword = "%" + keyword + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("defectName")), likeKeyword.toLowerCase()),
                    cb.like(cb.lower(root.join("vehicles").get("name")), likeKeyword.toLowerCase()),
                    cb.like(cb.lower(root.join("locations").get("locationName")), likeKeyword.toLowerCase())
            );
        };
    }

    public static Specification<Defect> hasVehicleId(Long vehicleId) {
        return (root, query, cb) -> {
            jakarta.persistence.criteria.Join<Defect, Vehicle> vehicleJoin = root.join("vehicles");
            return cb.equal(vehicleJoin.get("id"), vehicleId);
        };
    }

    public static Specification<Defect> hasLocationId(Long locationId) {
        return (root, query, cb) -> {
            Join<Defect, DefectLocation> locationJoin = root.join("locations");
            return cb.equal(locationJoin.get("id"), locationId);
        };
    }
}
