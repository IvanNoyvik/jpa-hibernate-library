package by.gomel.noyvik.library.service;

import by.gomel.noyvik.library.model.Order;

import java.util.List;


public interface OrderService extends CrudService<Order> {

    List<Order> findByBookId(Long id);

    List<Order> findByUserId(Long id);

    List<Order> findAllOverdueOrder();

    boolean findByBookAndUserId(Long bookId, Long userId);

    int findNumberOfOverdueOrdersByUserId(Long userId);



}
