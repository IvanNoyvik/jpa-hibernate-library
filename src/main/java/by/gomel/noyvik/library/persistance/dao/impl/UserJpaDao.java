package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.UserDao;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
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

    @Override
    public User findByLoginAndPasswordSqlQuery(String login, String password) {
        return null;
    }

    @Override
    public User findByLoginSqlQuery(String login) {
        return null;
    }

}
