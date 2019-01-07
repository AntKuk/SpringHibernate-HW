package com.netcracker.dao;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    void saveCustomer(Customer entity);
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
    Customer updateCustomerById(int id, String lastname);
    long countRows();
    public List<Customer> getNizhegorodCustomers();
}
