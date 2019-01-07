package com.netcracker.service;

import com.netcracker.dao.IShopDAO;
import com.netcracker.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopService implements IShopService{
    @Autowired
    IShopDAO shopDAO;

    public void saveShop (Shop shop) {
        shopDAO.saveShop(shop);
    }

    public List<Shop> findAllShops() {
        return shopDAO.findAllShops();
    }

    public Shop findShopById(int id) {
        return shopDAO.findShopById(id);
    }

    public void deleteShopById(int id) {
        shopDAO.deleteShopById(id);
    }

    public Shop updateShopById(int id, String shopName) {
        return shopDAO.updateShopById(id, shopName);
    }

    public long countRows() {
        return shopDAO.countRows();
    }

    public List<String> getDistrictShopName() {
        return shopDAO.getDistrictShopName();
    }

    public List<String> getShopNameExceptAvtozavod () {
        return shopDAO.getShopNameExceptAvtozavod();
    }
}
