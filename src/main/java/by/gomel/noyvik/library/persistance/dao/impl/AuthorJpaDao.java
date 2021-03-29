package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.persistance.dao.AuthenticateDao;
import by.gomel.noyvik.library.persistance.dao.AuthorDao;


public class AuthorJpaDao extends AbstractJpaCrudDao<Author> implements AuthorDao {


    @Override
    public Author findByAuthor(String author) {
        return null;
    }
}
