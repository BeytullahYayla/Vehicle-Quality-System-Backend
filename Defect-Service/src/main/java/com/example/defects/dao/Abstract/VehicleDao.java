package com.example.defects.dao.Abstract;
import com.example.defects.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle,Integer> {
}
