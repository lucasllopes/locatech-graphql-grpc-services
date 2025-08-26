package dev.lucaslopes.locatech.vehiclecatalog.service.handler;

import dev.lucaslopes.locatech.vehiclecatalog.exception.VehicleNotFoundException;
import dev.lucaslopes.locatech.vehiclecatalog.repository.VehicleRepository;
import dev.lucaslopes.locatech.vehiclecatalog.utils.EntityMessageMapper;
import org.springframework.stereotype.Service;
import dev.lucaslopes.locatech.catalog.GetVehicleByIdResponse;
import dev.lucaslopes.locatech.catalog.GetVehicleByIdRequest;
import dev.lucaslopes.locatech.catalog.ListAvailableVehiclesResponse;
import dev.lucaslopes.locatech.catalog.AddVehicleResponse;
import dev.lucaslopes.locatech.catalog.AddVehicleRequest;

@Service
public class VehicleCatalogRequestHandler {
  
  private final VehicleRepository vehicleRepository;
  
  public VehicleCatalogRequestHandler(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }
  
  public GetVehicleByIdResponse getVehicleById(GetVehicleByIdRequest request) {
    var vehicle = vehicleRepository.findById(request.getId()).orElseThrow(() -> new VehicleNotFoundException(request.getId()));
    
    return EntityMessageMapper.toVehicleProtoMessage(vehicle);
  }
  
  public ListAvailableVehiclesResponse getAllAvailableVehicles() {
    var vehicles = vehicleRepository.findByAvailableTrue();
    return EntityMessageMapper.toListAvailableVehicleReponseMessage(vehicles);    
  }
  
  public AddVehicleResponse saveVehicle(AddVehicleRequest request) {
    var vehicleEntity = EntityMessageMapper.toEntity(request);
    var vehicleSave = vehicleRepository.save(vehicleEntity);
    return EntityMessageMapper.toAddVehicleResponseMessage(vehicleSave);
  }  

}
