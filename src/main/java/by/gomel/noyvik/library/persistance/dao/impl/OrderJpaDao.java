package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.model.Order;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.MessageDao;
import by.gomel.noyvik.library.persistance.dao.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;


public class OrderJpaDao extends AbstractJpaCrudDao<Order> implements OrderDao {


    @Override
    public List<Order> findByBookId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders;
        try {
            orders = entityManager.createQuery("SELECT o from Order o join fetch o.book b " +
                    "join fetch b.author where b.id = :id", Order.class)
                    .setParameter("id", id).getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoPartException(e.getMessage(), e);
        } finally {
            entityManager.close();
        }

        return orders;
    }

    @Override
    public List<Order> findByUserId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders;
        try {
            orders = entityManager.createQuery("SELECT o from Order o join fetch o.book b " +
                    "join fetch b.author where o.user.id = :id", Order.class)
                    .setParameter("id", id).getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoPartException(e.getMessage(), e);
        } finally {
            entityManager.close();
        }

        return orders;    }

    @Override
    public List<Order> findAllOverdueOrder() {
        return null;
    }

    @Override
    public boolean findByBookAndUserId(Long bookId, Long userId) {
        return false;
    }

    @Override
    public int findNumberOfOverdueOrdersByUserId(Long userId) {
        return 0;
    }
}
