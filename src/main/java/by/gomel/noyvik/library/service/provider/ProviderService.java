package by.gomel.noyvik.library.service.provider;

import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.MessageService;
import by.gomel.noyvik.library.service.OrderService;
import by.gomel.noyvik.library.service.UserService;
import by.gomel.noyvik.library.service.impl.BookServiceImpl;
import by.gomel.noyvik.library.service.impl.MessageServiceImpl;
import by.gomel.noyvik.library.service.impl.OrderServiceImpl;
import by.gomel.noyvik.library.service.impl.UserServiceImpl;

public final class ProviderService {

    private static final ProviderService INSTANCE = new ProviderService();

    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final MessageService messageService = new MessageServiceImpl();


    private ProviderService(){}

    public static ProviderService getInstance() {
        return INSTANCE;
    }


    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public MessageService getMessageService() { return messageService;
    }
}
