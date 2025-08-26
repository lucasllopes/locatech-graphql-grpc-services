package dev.lucaslopes.locatech.aggregatorservice.controller;

import dev.lucaslopes.locatech.aggregatorservice.dto.CompleteReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.CreateReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.ReservationDTO;
import dev.lucaslopes.locatech.aggregatorservice.service.ReservationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
  
  private final ReservationService reservationService;
  
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }
  
  // nome do metodo deve ser igual ao do schema
  @QueryMapping
  public ReservationDTO getReservationById(@Argument Long reservationId) {
    return reservationService.getReservationById(reservationId);    
  }
  
  @MutationMapping
  public CreateReservationResponseDTO createReservation(@Argument ReservationDTO reservation) {
    return reservationService.createReservation(reservation);
  }

  @MutationMapping
  public CompleteReservationResponseDTO completeReservation(@Argument Long reservationId) {
    return reservationService.completeReservation(reservationId);
  }  
}
