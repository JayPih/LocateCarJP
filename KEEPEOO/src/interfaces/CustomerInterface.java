package interfaces;

import enums.TypeDocument;
import models.Customer;

public interface CustomerInterface {
    void addCustomer(String id, String name,String document, TypeDocument typeDocument);
    Customer findCustomerById(String id);
    boolean updateCustomer(String id, String newName, String newDocument, TypeDocument newtypeDocument);

}
