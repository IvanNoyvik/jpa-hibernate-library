package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.model.Order;
import by.gomel.noyvik.library.persistance.dao.MessageDao;
import by.gomel.noyvik.library.persistance.dao.OrderDao;

import java.util.List;


public class OrderJpaDao extends AbstractJpaCrudDao<Order> implements OrderDao {


    @Override
    public List<Order> findByBookId(Long id) {
        return null;
    }

    @Override
    public List<Order> findByUserId(Long id) {
        return null;
    }

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
