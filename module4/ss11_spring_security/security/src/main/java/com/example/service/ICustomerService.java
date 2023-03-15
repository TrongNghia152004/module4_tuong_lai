package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;

import java.util.List;


public interface ICustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId) throws ResourceNotFoundException;

    void deleteCustomer(int theId) throws ResourceNotFoundException;

    List<Customer> findCustomersByFirstName(String name);
}
