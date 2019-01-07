package com.netcracker.dao;

import com.netcracker.model.Book;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BasicDAO implements IBookDAO {
    public void saveBook(Book book) {
        persist(book);
    }

    public List<Book> findAllBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.setFetchMode("purchases", FetchMode.JOIN);
        return criteria.list();
    }

    public Book findBookById(int id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        return (Book) criteria.uniqueResult();
    }

    public void deleteBookById(int id) {
        Query query = getSession().createQuery("delete from Book where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public Book updateBookById(int id, String title) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        Book book = (Book) criteria.uniqueResult();
        book.setTitle(title);
        update(book);
        return book;
    }

    public long countRows() {
        Object result = getSession().createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult();
        long count = Long.parseLong(result.toString());
        return count;
    }

    public List<Book> getSpecialBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        Criterion title = Restrictions.like("title", "%Windows%");
        Criterion cost = Restrictions.gt("cost", 2000);

        LogicalExpression orExp = Restrictions.or(title, cost);

        criteria.add(orExp);
        criteria.addOrder(Order.asc("title"));
        criteria.addOrder(Order.desc("cost"));

        return criteria.list();
    }

    public List getBookBoughtInStockDistrict() {
        String sql = "SELECT b.title, b.stock, b.quantity, b.cost FROM purchase p, shop s, book b\n" +
                "WHERE p.book_id=b.book_id AND p.shop_id=s.shop_id AND s.shop_district=b.stock AND b.quantity>10 ORDER BY b.cost;";
        SQLQuery query = getSession().createSQLQuery(sql);
        return query.list();
    }



}
