package com.netcracker.dao;

import com.netcracker.model.Purchase;

import java.util.List;

public interface IPurchaseDAO {
    void savePurchase(Purchase entity);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    void deletePurchaseById(int id);
    Purchase updatePurchaseById(int id, int qty);
    long countRows();
    List<String> getPurchaseDetailInfo();
    List<Purchase> getPurchasesOver6000();
    List getPurchasesInMyDistrict();
}
