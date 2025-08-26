package dev.lucaslopes.locatech.vehiclecatalog.repository;

import dev.lucaslopes.locatech.vehiclecatalog.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  
  List<Vehicle> findByAvailableTrue();
  
}
