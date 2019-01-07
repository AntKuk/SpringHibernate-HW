package com.netcracker.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", nullable = false)
    private int custId;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "cust_district", nullable = false)
    private String custDistrict;

    @Column(name = "discount", nullable = false)
    private int discount;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();


    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }






    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustDistrict() {
        return custDistrict;
    }

    public void setCustDistrict(String custDistrict) {
        this.custDistrict = custDistrict;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Customer() {
    }

    public Customer(String lastName, String custDistrict, int discount) {
        this.lastName = lastName;
        this.custDistrict = custDistrict;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + custId +
                ", lastName='" + lastName + '\'' +
                ", custDistrict='" + custDistrict + '\'' +
                ", discount=" + discount +
                '}';
    }
}
