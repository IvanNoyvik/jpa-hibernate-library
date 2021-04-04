package by.gomel.noyvik.library.service.provider;

import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.UserService;
import by.gomel.noyvik.library.service.impl.BookServiceImpl;
import by.gomel.noyvik.library.service.impl.UserServiceImpl;

public final class ProviderService {

    private static final ProviderService INSTANCE = new ProviderService();

    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = new UserServiceImpl();



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
}
