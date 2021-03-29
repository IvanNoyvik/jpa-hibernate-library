package by.gomel.noyvik.library.persistance.dao;

import by.gomel.noyvik.library.model.Order;

import java.util.List;

public interface OrderDao extends CrudDao<Order> {

    List<Order> findByBookId(long id);

    List<Order> findByUserId(long id);

    List<Order> findAllOverdueOrder();

    boolean findByBookAndUserId(long bookId, long userId);

    int findNumberOfOverdueOrdersByUserId(long userId);

}
