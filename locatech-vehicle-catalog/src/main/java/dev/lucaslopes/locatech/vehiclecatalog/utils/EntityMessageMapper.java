package dev.lucaslopes.locatech.vehiclecatalog.utils;

import dev.lucaslopes.locatech.vehiclecatalog.entity.Vehicle;
import dev.lucaslopes.locatech.catalog.AddVehicleRequest;
import dev.lucaslopes.locatech.catalog.GetVehicleByIdResponse;
import dev.lucaslopes.locatech.catalog.VehicleProto;
import dev.lucaslopes.locatech.catalog.ListAvailableVehiclesResponse;
import dev.lucaslopes.locatech.catalog.AddVehicleResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMessageMapper {

  public static Vehicle toEntity(AddVehicleRequest vehicleRequest) {
    return new Vehicle(
      vehicleRequest.getVehicle().getMake(),
      vehicleRequest.getVehicle().getModel(),
      vehicleRequest.getVehicle().getCategory(),
      vehicleRequest.getVehicle().getIsAvailable()
    );
  }

  public static GetVehicleByIdResponse toVehicleProtoMessage(Vehicle vehicle) {
    return GetVehicleByIdResponse.newBuilder().setVehicle(
      VehicleProto.newBuilder()
        .setId(vehicle.getId())
        .setMake(vehicle.getMake())
        .setCategory(vehicle.getCategory())
        .setModel(vehicle.getModel())
        .setIsAvailable(vehicle.isAvailable())
        .build()
    ).build();
  }

  public static ListAvailableVehiclesResponse toListAvailableVehicleReponseMessage(List<Vehicle> vehicles) {
    var vehiclesProto = vehicles.stream().map(vehicle -> VehicleProto.newBuilder().setId(vehicle.getId())
      .setMake(vehicle.getMake())
      .setCategory(vehicle.getCategory())
      .setModel(vehicle.getModel())
      .setIsAvailable(vehicle.isAvailable())
      .build()
    ).collect(Collectors.toList());
    
    return ListAvailableVehiclesResponse.newBuilder().addAllVehicles(vehiclesProto).build();
  }
  
  public static AddVehicleResponse toAddVehicleResponseMessage(Vehicle vehicle) {
    return AddVehicleResponse.newBuilder()
      .setVehicleId(vehicle.getId())
      .setMessage("Vehicle added successfully").build();
  }
}
