package com.netcracker.service;

import com.netcracker.model.Book;

import java.util.List;
import java.util.Map;

public interface IBookService {
    void saveBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteBookById(int id);
    Book updateBookById(int id, String title);
    long countRows();
    Map<String, Integer> getAllTitleAndCost();
    List<Book> getSpecialBooks();
    void getBookBoughtInStockDistrict();
}
