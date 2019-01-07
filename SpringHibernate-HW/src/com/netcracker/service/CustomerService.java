package com.netcracker.service;

import com.netcracker.dao.ICustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("customerService")
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerDAO customerDAO;

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    public void deleteCustomerById(int id) {
        customerDAO.deleteCustomerById(id);
    }

    public Customer updateCustomerById(int id, String lastname) {
        return customerDAO.updateCustomerById(id, lastname);
    }

    public long countRows() {
        return customerDAO.countRows();
    }

    public Set<String> getDistricts() {
        List<Customer> customers = customerDAO.findAllCustomers();
        Set<String> districts = new HashSet<>();

        for(Customer customer : customers) {
            districts.add(customer.getCustDistrict());
        }

        return districts;
    }

    public void getNizhegorodCustomers() {
        List<Customer> customers = customerDAO.getNizhegorodCustomers();
        for(Customer customer : customers) {
            System.out.println(customer.getLastName() + " = " + customer.getDiscount());
        }
    }
}
