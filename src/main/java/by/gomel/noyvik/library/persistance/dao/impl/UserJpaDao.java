package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.UserDao;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UserJpaDao extends AbstractJpaCrudDao<User> implements UserDao {

//    @Override
//    public List<User> findAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
//        users.forEach(user -> user.getRoles().forEach(Hibernate::initialize));
//        entityManager.close();
//
//        return users;
//    }



    //todo
    @Override
    public User findByLoginAndPasswordSqlQuery(String login, String password) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user;
        try {
            user = (User) entityManager.createQuery("SELECT u from User u join fetch u.authenticate a " +
                    "join fetch u.orders join fetch u.roles join fetch u.status " +
                    "where a.login = :login and a.password = :password")
                    .setParameter("login", login).setParameter("password", password).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoPartException(e.getMessage(), e);
        } finally {
            entityManager.close();
        }

        return user;

    }

    @Override
    public User findByLoginSqlQuery(String login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user;
        try {
            user = (User) entityManager.createQuery("SELECT u from User u join fetch u.authenticate a " +
                    "where a.login = :login")
                    .setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoPartException(e.getMessage(), e);
        } finally {
            entityManager.close();
        }
        return user;
    }

}
