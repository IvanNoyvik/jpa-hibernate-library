package by.gomel.noyvik.library.service;

import by.gomel.noyvik.library.model.Book;

import java.io.InputStream;
import java.util.List;

public interface BookService {
    List<Book> findAll();

    void addImage(long id, InputStream inputStream);
}
