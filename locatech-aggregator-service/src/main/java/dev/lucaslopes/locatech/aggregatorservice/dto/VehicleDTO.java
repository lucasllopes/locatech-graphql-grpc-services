package dev.lucaslopes.locatech.aggregatorservice.dto;

import dev.lucaslopes.locatech.catalog.VehicleProto;
import dev.lucaslopes.locatech.reservation.ReservationProto;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;
import java.util.stream.Collectors;

@SchemaMapping("Vehicle")
public class VehicleDTO {

  private Long id;
  private String make;
  private String model;
  private String category;
  private Boolean isAvailable;

  public VehicleDTO(Long id, String make, String model, String category, Boolean isAvailable) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.category = category;
    this.isAvailable = isAvailable;
  }

  public VehicleDTO() {
  }

  public VehicleDTO(VehicleProto vehicleProto) {
    this.id = vehicleProto.getId();
    this.make = vehicleProto.getMake();
    this.model = vehicleProto.getModel();
    this.category = vehicleProto.getCategory();
    this.isAvailable = vehicleProto.getIsAvailable();
  }


  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getMake() { return make; }
  public void setMake(String make) { this.make = make; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public Boolean getIsAvailable() { return isAvailable; }
  public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
  
  public static List<VehicleDTO> fromProList(List<VehicleProto> vehicleProtoList) {
    return vehicleProtoList.stream().map(VehicleDTO::new).collect(Collectors.toList());
  }
  
}
