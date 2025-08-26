package dev.lucaslopes.locatech.vehiclecatalog.service;

import dev.lucaslopes.locatech.catalog.ListAvailableVehiclesResponse;
import dev.lucaslopes.locatech.catalog.AddVehicleRequest;
import dev.lucaslopes.locatech.catalog.AddVehicleResponse;
import dev.lucaslopes.locatech.catalog.CatalogServiceGrpc;
import dev.lucaslopes.locatech.catalog.GetVehicleByIdRequest;
import dev.lucaslopes.locatech.catalog.GetVehicleByIdResponse;
import dev.lucaslopes.locatech.catalog.ListAvailableVehiclesRequest;
import dev.lucaslopes.locatech.vehiclecatalog.service.handler.VehicleCatalogRequestHandler;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class VehicleService extends CatalogServiceGrpc.CatalogServiceImplBase {
  
  private final VehicleCatalogRequestHandler vehicleCatalogRequestHandler;
  
  public VehicleService(VehicleCatalogRequestHandler vehicleCatalogRequestHandler) {
    this.vehicleCatalogRequestHandler = vehicleCatalogRequestHandler;
  }
  @Override
  public void addVehicle(AddVehicleRequest request, StreamObserver<AddVehicleResponse> responseObserver) {
    var response = vehicleCatalogRequestHandler.saveVehicle(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void listAvailableVehicles(ListAvailableVehiclesRequest request, StreamObserver<ListAvailableVehiclesResponse> responseObserver) {
    var response = vehicleCatalogRequestHandler.getAllAvailableVehicles();
    responseObserver.onNext(response);
    responseObserver.onCompleted();    
  }

  @Override
  public void getVehicleById(GetVehicleByIdRequest request, StreamObserver<GetVehicleByIdResponse> responseObserver) {
    var response = vehicleCatalogRequestHandler.getVehicleById(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
