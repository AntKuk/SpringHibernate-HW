package com.netcracker.service;

import com.netcracker.dao.ICustomerDAO;
import com.netcracker.dao.IPurchaseDAO;
import com.netcracker.dao.IShopDAO;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService{
    @Autowired
    IPurchaseDAO purchaseDAO;
    @Autowired
    IShopDAO shopDAO;
    @Autowired
    ICustomerDAO customerDAO;


    public void savePurchase (Purchase purchase) {
        purchaseDAO.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseDAO.findAllPurchases();
    }

    public Purchase findPurchaseById(int id) {
        return purchaseDAO.findPurchaseById(id);
    }

    public void deletePurchaseById(int id) {
        purchaseDAO.deletePurchaseById(id);
    }

    public Purchase updatePurchaseById(int id, int qty) {
        return purchaseDAO.updatePurchaseById(id, qty);
    }

    public long countRows() {
        return purchaseDAO.countRows();
    }

    public Set<Integer> getPurchasedMothes() {
        List<Purchase> purchases = purchaseDAO.findAllPurchases();
        Set<Integer> monthes = new HashSet<>();

        for(Purchase purchase : purchases) {
            monthes.add(purchase.getDate().getMonth());
        }

        return monthes;
    }

    public void getLastnameAndShopname() {
        List<Purchase> purchaseList = purchaseDAO.findAllPurchases();
        List<LastnameAndShopname> list = new ArrayList<>();

        for(Purchase purchase : purchaseList) {
            Customer customer = customerDAO.findCustomerById(purchase.getCustId());
            Shop shop = shopDAO.findShopById(purchase.getShopId());

            list.add(new LastnameAndShopname(customer.getLastName(),shop.getShopName(), purchase.getOrderId()));
        }

        System.out.println(list);
    }

    private class LastnameAndShopname {
        private String lastname;
        private String shopname;
        private int orderId;

        public LastnameAndShopname(String lastname, String shopname, int orderId) {
            this.lastname = lastname;
            this.shopname = shopname;
            this.orderId = orderId;
        }

        @Override
        public String toString() {
            return "LastnameAndShopname{" +
                    "lastname='" + lastname + '\'' +
                    ", shopname='" + shopname + '\'' +
                    ", orderId=" + orderId +
                    '}';
        }
    }

    public List<String> getPurchaseDetailInfo() {
        return purchaseDAO.getPurchaseDetailInfo();
    }



    public void getPurchasesOver6000() {
        List<Purchase> list = purchaseDAO.getPurchasesOver6000();
        for(Purchase purchase : list) {
            System.out.println("Order id = " + purchase.getOrderId() + ", customer lastname = " + purchase.getCustomer().getLastName() + ", date = " + purchase.getDate());
        }

    }

    public void getPurchasesInMyDistrict() {
        List list = purchaseDAO.getPurchasesInMyDistrict();
        for(Object obj : list) {
            Object[] arr = (Object[]) obj;
            System.out.println("Lastname = " + arr[0] + ", district = " + arr[1] + ", date = " + arr[2]);
        }
    }
}
