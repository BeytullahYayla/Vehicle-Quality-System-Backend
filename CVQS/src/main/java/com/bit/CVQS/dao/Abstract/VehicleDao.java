package com.bit.CVQS.dao.Abstract;

import com.bit.CVQS.domain.Concrete.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle,Integer> {
}
