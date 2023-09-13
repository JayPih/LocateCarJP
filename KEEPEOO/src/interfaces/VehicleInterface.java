package interfaces;

import enums.TypeVehicle;
import models.Vehicle;

import java.util.List;

public interface VehicleInterface {
    void addVehicle(String plateNumber, String name, TypeVehicle typeVehicle);
    boolean updateVehicle(String plateNumber, String newName, TypeVehicle newTypeVehicle);
    List<Vehicle> findVehiclesPartOfName(String partialName);
    Vehicle findVehicleByPlateNumber(String plateNumber);

}
