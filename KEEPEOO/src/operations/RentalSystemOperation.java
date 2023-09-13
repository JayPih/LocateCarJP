package operations;

import interfaces.RentalSystemInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.RentalSystem;


public class RentalSystemOperation implements RentalSystemInterface {
    private List<RentalSystem> rentals = new ArrayList<>();

    @Override
    public void rentVehicle(String rentalId, String plateNumber, String customerId, Date startDate, String startHour, String rentalLocation) {
        RentalSystem rental = new RentalSystem(rentalId, plateNumber, customerId, startDate, startHour, null, null, rentalLocation);
        rentals.add(rental);
        System.out.println("Vehicle with plate number " + plateNumber + " has been rented.");
    }

    @Override
    public void returnVehicle(String rentalId, Date endDate, String endHour) {
        RentalSystem rentalToUpdate = findRentalById(rentalId);
        if (rentalToUpdate != null) {
            rentalToUpdate.setEndDate(endDate);
            rentalToUpdate.setEndHour(endHour);
            System.out.println("Vehicle with plate number " + rentalToUpdate.getPlateNumber() + " has been returned.");
        }
    }

    @Override
    public RentalSystem findRentalById(String rentalId) {
        for (RentalSystem rental : rentals) {
            if (rental.getRentalId().equals(rentalId)) {
                return rental;
            }
        }
        return null;

    }


}

