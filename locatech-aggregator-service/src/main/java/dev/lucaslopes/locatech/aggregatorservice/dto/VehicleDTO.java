package dev.lucaslopes.locatech.aggregatorservice.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

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
}
