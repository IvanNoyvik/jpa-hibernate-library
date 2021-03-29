package by.gomel.noyvik.library.persistance.connection;

import by.gomel.noyvik.library.persistance.dao.*;
import by.gomel.noyvik.library.persistance.dao.impl.*;

public final class ProviderDao {

    private static final ProviderDao INSTANCE = new ProviderDao();


    private final AuthenticateDao authenticateDao = new AuthenticateJpaDao();
    private final AuthorDao authorDao = new AuthorJpaDao();
    private final BookDao bookDao = new BookJpaDao();
    private final GenreDao genreDao = new GenreJpaDao();
    private final MessageDao messageDao = new MessageJpaDao();
    private final OrderDao orderDao = new OrderJpaDao();
    private final RoleDao roleDao = new RoleJpaDao();
    private final StatusDao statusDao = new StatusJpaDao();
    private final UserDao userDao = new UserJpaDao();



    private ProviderDao(){}

    public static ProviderDao getInstance(){
        return INSTANCE;
    }

    public AuthenticateDao getAuthenticateDao() {
        return authenticateDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public GenreDao getGenreDao() {
        return genreDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public StatusDao getStatusDao() {
        return statusDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
