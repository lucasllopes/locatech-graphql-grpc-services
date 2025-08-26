package dev.lucaslopes.locatech.vehiclecatalog.service.exception;

import dev.lucaslopes.locatech.vehiclecatalog.exception.VehicleNotFoundException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ServiceExceptionHandler {
  
  @GrpcExceptionHandler(VehicleNotFoundException.class)
  public Status handleVehicleNotFound(VehicleNotFoundException ex) {
    return Status.INVALID_ARGUMENT.withDescription(ex.getMessage()).withCause(ex);
  }
}
