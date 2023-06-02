package com.example.defects.core.spesifications;

import com.example.defects.domain.Defect;
import com.example.defects.domain.DefectLocation;
import com.example.defects.domain.Vehicle;
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
                    cb.like(cb.lower(root.get("defectName")), likeKeyword.toLowerCase())
            );
        };
    }

    public static Specification<Defect> hasVehicleId(Long vehicleId) {
        return (root, query, cb) -> {
            Join<Defect, Vehicle> vehicleJoin = root.join("vehicles");
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
