package dev.lucaslopes.locatech.aggregatorservice.controller;

import dev.lucaslopes.locatech.aggregatorservice.dto.AddVehicleResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.VehicleAndReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.VehicleDTO;
import dev.lucaslopes.locatech.aggregatorservice.service.VehicleService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @QueryMapping
  public VehicleDTO getVehicleById(@Argument Long id) {
    return vehicleService.getVehicleById(id);
  }

  @QueryMapping
  public List<VehicleDTO> listAvailableVehicles() {
    return vehicleService.listAvailableVehicles();
  }

  @QueryMapping
  public VehicleAndReservationResponseDTO getVehicleAndReservationById(@Argument Long vehicleId) {
    return vehicleService.getVehicleAndReservationById(vehicleId);
  }

  @MutationMapping
  public AddVehicleResponseDTO addVehicle(@Argument VehicleDTO vehicle) {
    return vehicleService.addVehicle(vehicle);
  }
}
