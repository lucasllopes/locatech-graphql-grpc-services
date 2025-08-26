package dev.lucaslopes.locatech.vehiclecatalog.exception;

public class VehicleNotFoundException extends RuntimeException {
  
  private static final String MESSAGE = "Vehicle [id=%d] is not found";
  public VehicleNotFoundException(Long id) {
    super(MESSAGE.formatted((id)));
    
  }
}
