package com.netcracker.dao;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookDAO {
    void saveBook(Book entity);

    List<Book> findAllBooks();

    Book findBookById(int id);

    void deleteBookById(int id);

    Book updateBookById(int id, String title);

    long countRows();
    List<Book> getSpecialBooks();
    public List getBookBoughtInStockDistrict();
}
