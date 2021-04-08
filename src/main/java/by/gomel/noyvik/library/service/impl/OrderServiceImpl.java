package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.model.Order;
import by.gomel.noyvik.library.persistance.dao.OrderDao;
import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.OrderService;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class OrderServiceImpl extends AbstractCrudService<Order> implements OrderService {

    private final OrderDao orderDao = PROVIDER_DAO.getOrderDao();

    @Override
    public List<Order> findByBookId(Long id) {
        return orderDao.findByBookId(id);
    }

    @Override
    public List<Order> findByUserId(Long id) {
        return orderDao.findByUserId(id);
    }

    @Override
    public List<Order> findAllOverdueOrder() {
        return orderDao.findAllOverdueOrder();
    }

    @Override
    public boolean findByBookAndUserId(Long bookId, Long userId) {
        return orderDao.findByBookAndUserId(bookId, userId);
    }

    @Override
    public int findNumberOfOverdueOrdersByUserId(Long userId) {
        return orderDao.findNumberOfOverdueOrdersByUserId(userId);
    }



}
