package com.netcracker.service;

import com.netcracker.model.Shop;

import java.util.List;

public interface IShopService {
    void saveShop(Shop shop);
    List<Shop> findAllShops();
    Shop findShopById(int id);
    void deleteShopById(int id);
    Shop updateShopById(int id, String shopName);
    long countRows();
    List<String> getDistrictShopName();
    List<String> getShopNameExceptAvtozavod ();

}
