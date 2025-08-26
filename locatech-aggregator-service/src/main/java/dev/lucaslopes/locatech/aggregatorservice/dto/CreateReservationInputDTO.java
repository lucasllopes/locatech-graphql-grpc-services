package dev.lucaslopes.locatech.aggregatorservice.dto;

public class CreateReservationInputDTO {

  private Long vehicleId;
  private Long userId;
  private String startDate;
  private String endDate;

  public CreateReservationInputDTO(Long vehicleId, Long userId, String startDate, String endDate) {
    this.vehicleId = vehicleId;
    this.userId = userId;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Long getVehicleId() { return vehicleId; }
  public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }

  public String getStartDate() { return startDate; }
  public void setStartDate(String startDate) { this.startDate = startDate; }

  public String getEndDate() { return endDate; }
  public void setEndDate(String endDate) { this.endDate = endDate; }
}
