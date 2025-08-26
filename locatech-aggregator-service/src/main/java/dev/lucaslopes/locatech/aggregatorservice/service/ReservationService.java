package dev.lucaslopes.locatech.aggregatorservice.service;

import dev.lucaslopes.locatech.aggregatorservice.dto.CompleteReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.CreateReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.ReservationDTO;
import dev.lucaslopes.locatech.reservation.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
  // nome de acordo com o properties
  @GrpcClient("reservation")
  private ReservationServiceGrpc.ReservationServiceBlockingStub reservationServiceBlockingStub;
  
  public ReservationDTO getReservationById(Long reservationId) {
    var request = GetReservationRequest.newBuilder()
      .setReservationId(reservationId)
      .build();
    
    var response = reservationServiceBlockingStub.getReservation(request);
    return new ReservationDTO(response.getReservation());
  } 
  
  public CreateReservationResponseDTO createReservation(ReservationDTO reservation) {
    var request = CreateReservationRequest.newBuilder()
      .setVehicleId(reservation.getVehicleId())
      .setUserId(reservation.getUserId())
      .setStartDate(reservation.getStartDate())
      .setEndDate(reservation.getEndDate())
      .build();
    var response = reservationServiceBlockingStub.createReservation(request);
    return new CreateReservationResponseDTO(response.getReservationId(), response.getMessage());    
  }
  
  public CompleteReservationResponseDTO completeReservation(Long reservationId) {
    var request = CompleteReservationRequest.newBuilder().setReservationId(reservationId).build();
    var response = reservationServiceBlockingStub.completeReservation(request);
    return new CompleteReservationResponseDTO(response.getMessage(), response.getTotalDays());
  }
  
}
