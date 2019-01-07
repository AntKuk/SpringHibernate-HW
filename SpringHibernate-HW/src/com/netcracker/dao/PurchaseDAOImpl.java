package com.netcracker.dao;


import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BasicDAO implements IPurchaseDAO {
    public void savePurchase(Purchase purchase) {
        persist(purchase);
    }

    public List<Purchase> findAllPurchases() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        //criteria.setFetchMode("shop", FetchMode.JOIN);
        return criteria.list();
    }

    public Purchase findPurchaseById(int id) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id",id));
        return (Purchase) criteria.uniqueResult();
    }

    public void deletePurchaseById(int id) {
        Query query = getSession().createQuery("delete from Purchase where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public Purchase updatePurchaseById(int id, int qty) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id",id));
        Purchase purchase = (Purchase) criteria.uniqueResult();
        purchase.setQuantity(qty);
        update(purchase);
        return purchase;
    }

    public long countRows() {
        Object result = getSession().createCriteria(Purchase.class).setProjection(Projections.rowCount()).uniqueResult();
        long count = Long.parseLong(result.toString());
        return count;
    }

    public List<String> getPurchaseDetailInfo() {
        String sql = "SELECT p.order_id, c.lastname, c.discount, b.title, p.quantity\n" +
                "FROM purchase p, customer c, book b\n" +
                "WHERE p.cust_id = c.cust_id AND p.book_id = b.book_id;";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<String> results = query.list();

        return results;

    }

    public List<Purchase> getPurchasesOver6000() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.gt("total", 6000));
        return criteria.list();
    }


    public List getPurchasesInMyDistrict() {
        Query query = getSession().createQuery("select c.lastName, c.custDistrict, p.date from Purchase p join p.shop s join p.customer c where c.custDistrict=s.shopDistrict");
        List list = query.list();
        return list;

    }


}
