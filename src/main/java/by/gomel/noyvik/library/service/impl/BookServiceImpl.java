package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.persistance.connection.ProviderDao;
import by.gomel.noyvik.library.service.BookService;

import java.io.InputStream;
import java.util.List;

public class BookServiceImpl implements BookService {

    private ProviderDao providerDao = ProviderDao.getInstance();


    @Override
    public List<Book> findAll(){
        return providerDao.getBookDao().findAll();
    }

    @Override
    public void addImage(long id, InputStream inputStream) {
        providerDao.getBookDao().addImage(id,inputStream);
    }


}
