package models;

import enums.TypeVehicle;

public class Vehicle {
    private String plateNumber;
    private String name;
    private TypeVehicle typeVehicle;
    private boolean available;

    public Vehicle(String plateNumber, String name, TypeVehicle typeVehicle) {
        this.plateNumber = plateNumber;
        this.name = name;
        this.typeVehicle = typeVehicle;
        this.available = available;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
