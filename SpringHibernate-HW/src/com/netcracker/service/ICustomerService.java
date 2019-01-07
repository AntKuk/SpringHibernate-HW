package com.netcracker.service;

import com.netcracker.model.Customer;

import java.util.List;
import java.util.Set;

public interface ICustomerService {
    void saveCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
    Customer updateCustomerById(int id, String lastname);
    long countRows();
    public Set<String> getDistricts();
    public void getNizhegorodCustomers();
}
