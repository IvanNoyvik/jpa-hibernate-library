package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.persistance.dao.AuthenticateDao;
import by.gomel.noyvik.library.persistance.dao.BookDao;

import java.io.InputStream;


public class BookJpaDao extends AbstractJpaCrudDao<Book> implements BookDao {


    //TODO !!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public byte[] findImageById(Long id) {
        return new byte[0];
    }

    @Override
    public void addImage(Long id, InputStream inputStream) {

    }

    @Override
    public boolean findByTitleAndAuthor(String title, String author) {
        return false;
    }
}
