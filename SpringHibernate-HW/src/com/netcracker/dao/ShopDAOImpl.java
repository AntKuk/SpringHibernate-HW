package com.netcracker.dao;


import com.netcracker.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BasicDAO implements IShopDAO {
    public void saveShop(Shop shop) {
        persist(shop);
    }

    public List<Shop> findAllShops() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.setFetchMode("purchases", FetchMode.JOIN);
        return criteria.list();
    }

    public Shop findShopById(int id) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("id",id));
        return (Shop) criteria.uniqueResult();
    }

    public void deleteShopById(int id) {
        Query query = getSession().createQuery("delete from Shop where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public Shop updateShopById(int id, String shopName) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("id",id));
        Shop shop = (Shop) criteria.uniqueResult();
        shop.setShopName(shopName);
        update(shop);
        return shop;
    }

    public long countRows() {
        Object result = getSession().createCriteria(Shop.class).setProjection(Projections.rowCount()).uniqueResult();
        long count = Long.parseLong(result.toString());
        return count;
    }

    public List<String> getDistrictShopName() {
        String sql = "SELECT shop_name FROM shop WHERE shop_district='Soviet' OR shop_district='Sormovo'";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setResultTransformer(Criteria.ROOT_ENTITY);
        List<String> results = query.list();

        return results;

    }

    public List<String> getShopNameExceptAvtozavod () {
        String sql = "select shop_name FROM shop where shop_id IN\n" +
                "(select p.shop_id\n" +
                "from purchase p\n" +
                "WHERE p.shop_id IN (SELECT shop_id FROM shop WHERE shop_name <> 'Autoplane') AND p.cust_id IN (SELECT cust_id FROM customer WHERE discount BETWEEN 10 AND 15)); ";

        SQLQuery query = getSession().createSQLQuery(sql);
        query.setResultTransformer(Criteria.ROOT_ENTITY);
        List<String> results = query.list();

        return results;
    }

}
