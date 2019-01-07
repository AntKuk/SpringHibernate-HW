package com.netcracker.service;

import com.netcracker.dao.IBookDAO;
import com.netcracker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("bookService")
public class BookService implements IBookService{
    @Autowired
    IBookDAO bookDAO;

    public void saveBook (Book book) {
        bookDAO.saveBook(book);
    }

    public List<Book> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    public Book findBookById(int id) {
        return bookDAO.findBookById(id);
    }

    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }

    public Book updateBookById(int id, String title) {
        return bookDAO.updateBookById(id, title);
    }

    public long countRows() {
        return bookDAO.countRows();
    }

    public Map<String, Integer> getAllTitleAndCost() {
        Map<String, Integer> desiredList = new HashMap<String, Integer>();
        List<Book> allBooks = bookDAO.findAllBooks();
        for(Book book : allBooks) {
            String title = book.getTitle();
            Integer cost = book.getCost();
            desiredList.put(title, cost);
        }
        return desiredList;
    }

    public List<Book> getSpecialBooks() {
        return bookDAO.getSpecialBooks();
    }

    public void getBookBoughtInStockDistrict() {
        List list = bookDAO.getBookBoughtInStockDistrict();
        for(Object obj : list) {
            Object[] arr = (Object[]) obj;
            System.out.println("Title = " + arr[0] + ", stock district = " + arr[1] + ", quantity = " + arr[2] + " , cost = " + arr[3]);
        }
    }
}
