package com.netcracker.dao;


import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BasicDAO implements ICustomerDAO {
    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.setFetchMode("purchases", FetchMode.JOIN);
        return criteria.list();
    }

    public Customer findCustomerById(int id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        return (Customer) criteria.uniqueResult();
    }

    public void deleteCustomerById(int id) {
        Query query = getSession().createQuery("delete from Customer where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public Customer updateCustomerById(int id, String lastname) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        Customer customer = (Customer) criteria.uniqueResult();
        customer.setLastName(lastname);
        update(customer);
        return customer;
    }

    public long countRows() {
        Object result = getSession().createCriteria(Customer.class).setProjection(Projections.rowCount()).uniqueResult();
        long count = Long.parseLong(result.toString());
        return count;
    }

    public List<Customer> getNizhegorodCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.like("custDistrict", "nizhegorodkiy"));
        return criteria.list();
    }

}
