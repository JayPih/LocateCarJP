package operations;

import enums.TypeDocument;
import interfaces.RentalCostCalculator;

import models.Customer;
import models.RentalSystem;

public class SuvRentalCost implements RentalCostCalculator {
    private double dailyRate;
    private CustomerOperation customerOperation;

    public SuvRentalCost(CustomerOperation customerOperation) {
        this.dailyRate = 200.0; // R$ 200.00 per day
        this.customerOperation = customerOperation;
    }

    @Override
    public double calculateRentalCost(RentalSystem rental) {
        long durationInHours = (rental.getEndDate().getTime() - rental.getStartDate().getTime()) / (60 * 60 * 1000);
        long fullDaysRented = durationInHours / 24;
        long remainingHours = durationInHours % 24;

        double totalCost = (fullDaysRented + (remainingHours > 0 ? 1 : 0)) * dailyRate;

        Customer customer = customerOperation.findCustomerById(rental.getCustomerId());
        if (customer != null && customer.getTypeDocument() == TypeDocument.CPF && fullDaysRented > 5) {
            totalCost *= 0.95;
        }
        else if (customer != null && customer.getTypeDocument() == TypeDocument.CNPJ && fullDaysRented > 3) {
            totalCost *= 0.90;
        }

        return totalCost;
    }
}

