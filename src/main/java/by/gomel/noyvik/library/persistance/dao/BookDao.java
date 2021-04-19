package by.gomel.noyvik.library.persistance.dao;

import by.gomel.noyvik.library.model.Book;

import java.io.InputStream;

public interface BookDao extends CrudDao<Book> {

    byte[] findImageById(Long id);

    void addImage(Long id, InputStream inputStream);

    boolean findByTitleAndAuthor(String title, String author);

    Book save(Book book, String[] genreName);
}
