package operations;

import enums.TypeDocument;
import interfaces.CustomerInterface;
import models.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerOperation implements CustomerInterface {
    private Set<Customer> customers = new HashSet<>();
    @Override
    public void addCustomer(String id, String name, String document, TypeDocument typeDocument) {
        Customer existingCustomer = findCustomerById(id);
        if (existingCustomer == null) {
            Customer customer = new Customer(id, name, document, typeDocument);
            customers.add(customer);
        } else {
            System.out.println("Customer with ID " + id + " already exists.");
        }
    }

    @Override
    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean updateCustomer(String id, String newName, String newDocument, TypeDocument newtypeDocument) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(newName);
                customer.setDocument(newDocument);
                customer.setTypeDocument(newtypeDocument);
                return true; // Updated successfully
            }
        }
        return false; // Customer not found
    }
}

