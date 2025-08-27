package dev.lucaslopes.locatech.aggregatorservice.service;

import dev.lucaslopes.locatech.aggregatorservice.dto.AddVehicleResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.ReservationDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.VehicleAndReservationResponseDTO;
import dev.lucaslopes.locatech.aggregatorservice.dto.VehicleDTO;
import dev.lucaslopes.locatech.catalog.*;
import dev.lucaslopes.locatech.reservation.GetReservationByVehicleIdRequest;
import dev.lucaslopes.locatech.reservation.ReservationServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {
  
  @GrpcClient("vehicle-catalog")
  private CatalogServiceGrpc.CatalogServiceBlockingStub catalogServiceBlockingStub;
  
  
  // nome de acordo com o properties
  @GrpcClient("reservation")
  private ReservationServiceGrpc.ReservationServiceBlockingStub reservationServiceBlockingStub;
  
  
  public VehicleDTO getVehicleById(Long vehicleId) {
    var request = GetVehicleByIdRequest.newBuilder().setId(vehicleId).build();
    var response = catalogServiceBlockingStub.getVehicleById(request);
    return new VehicleDTO(response.getVehicle());
  }
  
  public List<VehicleDTO> listAvailableVehicles() {
    var request = ListAvailableVehiclesRequest.newBuilder().build();
    var response = catalogServiceBlockingStub.listAvailableVehicles(request);
    return VehicleDTO.fromProList(response.getVehiclesList());
  }

  public AddVehicleResponseDTO addVehicle(VehicleDTO vehicleDTO) {
    VehicleProto vehicleProto = VehicleProto.newBuilder()
      .setMake(vehicleDTO.getMake())
      .setModel(vehicleDTO.getModel())
      .setCategory(vehicleDTO.getCategory())
      .setIsAvailable(vehicleDTO.getIsAvailable())
      .build();

    var request = AddVehicleRequest.newBuilder().setVehicle(vehicleProto).build();
    var response = catalogServiceBlockingStub.addVehicle(request);
    return new AddVehicleResponseDTO(response.getVehicleId(), response.getMessage());
  }

  public VehicleAndReservationResponseDTO getVehicleAndReservationById(Long vehicleId) {
    var vehicleRequest = GetVehicleByIdRequest.newBuilder().setId(vehicleId).build();
    var vehicleResponse = catalogServiceBlockingStub.getVehicleById(vehicleRequest);
    var vehicleDTO = new VehicleDTO(vehicleResponse.getVehicle());

    var reservationRequest = GetReservationByVehicleIdRequest.newBuilder().setVehicleId(vehicleId).build();
    var reservationResponse = reservationServiceBlockingStub.getReservationByVehicleId(reservationRequest);
    var reservationDTO = new ReservationDTO(reservationResponse.getReservation());

    return new VehicleAndReservationResponseDTO(vehicleDTO, reservationDTO);
  }

}
