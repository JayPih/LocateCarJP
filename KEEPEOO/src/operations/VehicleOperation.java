package operations;

import enums.TypeVehicle;
import interfaces.VehicleInterface;
import models.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VehicleOperation implements VehicleInterface {
    private Set<Vehicle> vehicles = new HashSet<>();
    @Override
    public void addVehicle(String plateNumber, String name, TypeVehicle typeVehicle) {
        Vehicle existingVehicle = findVehicleByPlateNumber(plateNumber);
        if (existingVehicle == null) {
            Vehicle vehicle = new Vehicle(plateNumber, name, typeVehicle);
            vehicles.add(vehicle);
        } else {
            System.out.println("Vehicle with plate number " + plateNumber + " already exists.");
        }
    }

    @Override
    public boolean updateVehicle(String plateNumber, String newName, TypeVehicle newTypeVehicle) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                vehicle.setName(newName);
                vehicle.setTypeVehicle(newTypeVehicle);
                return true; // Updated successfully
            }
        }
        return false; // Vehicle not found
    }

    @Override
    public List<Vehicle> findVehiclesPartOfName(String partialName) {
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().contains(partialName)) {
                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    @Override
    public Vehicle findVehicleByPlateNumber(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        return null;
    }
}
