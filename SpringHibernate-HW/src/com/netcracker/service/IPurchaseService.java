package com.netcracker.service;

import com.netcracker.model.Purchase;

import java.util.List;
import java.util.Set;

public interface IPurchaseService {

    void savePurchase(Purchase purchase);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    void deletePurchaseById(int id);
    Purchase updatePurchaseById(int id, int qty);
    long countRows();
    Set<Integer> getPurchasedMothes();
    public void getLastnameAndShopname();
    List<String> getPurchaseDetailInfo();
    void getPurchasesOver6000();
    void getPurchasesInMyDistrict();

}
