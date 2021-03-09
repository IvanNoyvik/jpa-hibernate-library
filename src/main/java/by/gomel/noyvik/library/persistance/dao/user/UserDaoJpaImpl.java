package by.gomel.noyvik.library.persistance.dao.user;


import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.AbstractCrudDao;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoJpaImpl extends AbstractCrudDao<User> {

    @Override
    public List<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        users.forEach(user -> user.getRoles().forEach(Hibernate::initialize));
        entityManager.close();

        return users;
    }
}
