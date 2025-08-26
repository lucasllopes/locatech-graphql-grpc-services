package dev.lucaslopes.locatech.aggregatorservice.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("VehicleAndReservationResponse")
public class VehicleAndReservationResponseDTO {

  private VehicleDTO vehicle;
  private ReservationDTO reservation;

  public VehicleAndReservationResponseDTO(VehicleDTO vehicle, ReservationDTO reservation) {
    this.vehicle = vehicle;
    this.reservation = reservation;
  }

  public VehicleDTO getVehicle() { return vehicle; }
  public void setVehicle(VehicleDTO vehicle) { this.vehicle = vehicle; }

  public ReservationDTO getReservation() { return reservation; }
  public void setReservation(ReservationDTO reservation) { this.reservation = reservation; }
}
