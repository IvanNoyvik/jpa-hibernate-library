package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.persistance.dao.AuthenticateDao;
import by.gomel.noyvik.library.persistance.dao.GenreDao;


public class GenreJpaDao extends AbstractJpaCrudDao<Genre> implements GenreDao {


    @Override
    public Genre findByGenre(String genre) {
        return null;
    }
}
