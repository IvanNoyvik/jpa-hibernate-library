package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.persistance.dao.AuthenticateDao;
import by.gomel.noyvik.library.persistance.dao.BookDao;

import javax.persistence.EntityManager;
import java.io.InputStream;
import java.util.List;


public class BookJpaDao extends AbstractJpaCrudDao<Book> implements BookDao {


    @Override
    public List<Book> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Book> books = entityManager.createQuery("SELECT b from Book b join fetch b.author").getResultList();
        entityManager.close();
        return books;
    }

    @Override
    public byte[] findImageById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        byte[] image = book.getImage();
        entityManager.close();
        return image;
    }
    //TODO !!!!!!!!!!!!!!!!!!!!!!!

    @Override
    public void addImage(Long id, InputStream inputStream) {

    }

    @Override
    public boolean findByTitleAndAuthor(String title, String author) {
        return false;
    }
}
