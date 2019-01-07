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
        bookService.getBookBoughtInStockDistrict();

        ICustomerService service = (ICustomerService) context.getBean("customerService");
        List<Customer> customerList = service.findAllCustomers();
        customerList.forEach(System.out::println);
        System.out.println(service.countRows());

    }
}
