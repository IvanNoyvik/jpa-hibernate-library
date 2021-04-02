package by.gomel.noyvik.library.service.provider;

import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.impl.BookServiceImpl;

public final class ProviderService {

    private static final ProviderService INSTANCE = new ProviderService();

    private BookService bookService = new BookServiceImpl();


    private ProviderService(){}

    public static ProviderService getInstance() {
        return INSTANCE;
    }


    public BookService getBookService() {
        return bookService;
    }

}
