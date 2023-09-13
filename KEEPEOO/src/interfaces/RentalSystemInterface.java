package interfaces;

import models.RentalSystem;

import java.util.Date;

public interface RentalSystemInterface {
    void rentVehicle(String rentalId, String plateNumber, String customerId, Date startDate, String startHour, String rentalLocation);
    void returnVehicle(String rentalId, Date endDate, String endHour);
    RentalSystem findRentalById(String rentalId);

}
