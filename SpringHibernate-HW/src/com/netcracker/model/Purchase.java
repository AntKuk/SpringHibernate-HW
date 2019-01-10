package com.netcracker.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "shop_id", nullable = false)
    private int shopId;

    @Column(name = "cust_id", nullable = false)
    private int custId;

    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total", nullable = false)
    private int total;


    @ManyToOne
    @JoinColumn(name = "shop_id", insertable = false, updatable = false)
    private Shop shop;


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(name = "cust_id", insertable = false, updatable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Purchase() {
    }

    public Purchase(Date date, int shopId, int custId, int bookId, int quantity, int total) {
        this.date = date;
        this.shopId = shopId;
        this.custId = custId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", shopId=" + shopId +
                ", custId=" + custId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
