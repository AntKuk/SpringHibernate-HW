package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.IBookService;
import com.netcracker.service.ICustomerService;
import com.netcracker.service.IPurchaseService;
import com.netcracker.service.IShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IBookService bookService = (IBookService) context.getBean("bookService");
        System.out.println(bookService.findAllBooks());
        System.out.println(bookService.findBookById(2));
        bookService.saveBook(new Book("NewTitle", 666, "NewDistrict", 3));
        System.out.println(bookService.findAllBooks());


        ICustomerService custService = (ICustomerService) context.getBean("customerService");
        System.out.println(custService.countRows());

        IPurchaseService purchaseService = (IPurchaseService) context.getBean("purchaseService");
        purchaseService.getPurchaseDetailInfo();
        purchaseService.savePurchase(new Purchase(new Date(2010,10,10),2,1,4,3,1000));
        bookService.getBookBoughtInStockDistrict();

    }
}
