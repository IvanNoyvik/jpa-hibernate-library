package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class UserDaoJsqlJpaImpl extends AbstractJpaCrudDao<User> {

    @Override
    public List<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public User findById(long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user =  entityManager.createQuery("select u from User u where u.id = ?1", User.class).setParameter(1, id).getSingleResult();
        entityManager.close();
        return user;
    }

    @Override
    public User save(User User) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("INSERT INTO USERS (NAME, EMAIL) VALUES (?1, ?2)")
                .setParameter(1, User.getName()).setParameter(2, User.getEmail())
                .executeUpdate();
        User user = entityManager.createQuery("from User order by id desc", User.class).setMaxResults(1).getSingleResult();

        entityManager.getTransaction().commit();

        entityManager.close();
        return user;
    }

    @Override
    public User update(User user) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.createQuery("update User set name = :userName, email = :email where id = :id")
                    .setParameter("userName", user.getName())
                    .setParameter("email", user.getEmail())
                    .setParameter("id", user.getId())
                    .executeUpdate();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            Optional.ofNullable(entityManager).map(EntityManager::getTransaction)
                    .ifPresent(EntityTransaction::rollback);

            e.printStackTrace();
            System.err.println("Error process update method for User - " + e.getMessage());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return user;
    }

    @Override
    public void deleteById(long id) {

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            Optional.ofNullable(entityManager).map(EntityManager::getTransaction)
                    .ifPresent(EntityTransaction::rollback);

            e.printStackTrace();
            System.err.println("Error process delete method for User - " + e.getMessage());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
