package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.exception.ServiceException;
import by.gomel.noyvik.library.model.Order;
import by.gomel.noyvik.library.persistance.dao.OrderDao;
import by.gomel.noyvik.library.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Order> orders = orderDao.findAll();

        List<Order> overdueOrders = orders.stream()
                .filter(o -> o.getDateReceiving().plusDays(o.getDuration()).isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        return overdueOrders;
    }

    @Override
    public boolean findByBookAndUserId(Long bookId, Long userId) {
        return orderDao.findByBookAndUserId(bookId, userId);
    }


}
