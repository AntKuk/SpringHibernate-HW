package com.netcracker.dao;

import com.netcracker.model.Shop;

import java.util.List;

public interface IShopDAO {

    void saveShop(Shop entity);

    List<Shop> findAllShops();

    Shop findShopById(int id);

    void deleteShopById(int id);

    Shop updateShopById(int id, String name);

    long countRows();
    List<String> getDistrictShopName();
    List<String> getShopNameExceptAvtozavod ();
}
