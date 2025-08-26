package dev.lucaslopes.locatech.aggregatorservice.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("CompleteReservationResponse")
public class CompleteReservationResponseDTO {

  private String message;
  private Long totalDays;

  public CompleteReservationResponseDTO(String message, Long totalDays) {
    this.message = message;
    this.totalDays = totalDays;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTotalDays() {
    return totalDays;
  }

  public void setTotalDays(Long totalDays) {
    this.totalDays = totalDays;
  }
}
