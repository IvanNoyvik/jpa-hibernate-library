package by.gomel.noyvik.library.service;

import by.gomel.noyvik.library.model.Book;

import java.io.InputStream;

public interface BookService extends CrudService<Book> {



    byte[] findImageById(Long id);

    void addImage(Long id, InputStream inputStream);

    boolean findByTitleAndAuthor(String title, String author);

    Book save(String title, String description, int quantity, String genres, String author);
}
