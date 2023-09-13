import java.util.Calendar;
import java.util.Date;

import models.Customer;
import operations.CustomerOperation;
import models.RentalSystem;
import enums.TypeDocument;
import enums.TypeVehicle;
import models.Vehicle;
import operations.VehicleOperation;
import operations.RentalSystemOperation;
import operations.PequenoRentalCost;
import interfaces.RentalCostCalculator;

public class Main {
    public static void main(String[] args) {
        CustomerOperation customerOperation = new CustomerOperation();
        VehicleOperation vehicleOperation = new VehicleOperation();
        RentalSystemOperation rentalOperation = new RentalSystemOperation();

        customerOperation.addCustomer("1", "JP", "12345", TypeDocument.CPF);
        customerOperation.addCustomer("2", "Amazon", "67890", TypeDocument.CNPJ);

        vehicleOperation.addVehicle("ABC123", "Monza GLS", TypeVehicle.PEQUENO);
        vehicleOperation.addVehicle("XYZ789", "Honda Civic", TypeVehicle.MEDIO);

        // 8 dias quebrados
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.HOUR, 175);
        Date endDate = calendar.getTime();
        rentalOperation.rentVehicle("R1", "ABC123", "1", startDate, "09:00", "Location A");
        rentalOperation.returnVehicle("R1", endDate, "19:00");

        Customer foundCustomer = customerOperation.findCustomerById("1");
        if (foundCustomer != null) {
            System.out.println("Found customer: " + foundCustomer.getName());
        } else {
            System.out.println("Customer not found.");
        }

        String partialName = "Mon";
        for (Vehicle vehicle : vehicleOperation.findVehiclesPartOfName(partialName)) {
            System.out.println("Found vehicle: " + vehicle.getName());
        }

        RentalSystem rentalPequeno = rentalOperation.findRentalById("R1");
        if (rentalPequeno != null) {
            RentalCostCalculator calculatorPequeno = new PequenoRentalCost(customerOperation);
            double costPequeno = calculatorPequeno.calculateRentalCost(rentalPequeno);
            System.out.println("Rental cost for PEQUENO vehicle: R$" + costPequeno);
        }
    }
}





