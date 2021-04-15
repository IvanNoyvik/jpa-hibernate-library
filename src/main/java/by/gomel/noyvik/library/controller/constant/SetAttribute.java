package by.gomel.noyvik.library.controller.constant;



import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.model.Order;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.MessageService;
import by.gomel.noyvik.library.service.OrderService;
import by.gomel.noyvik.library.service.UserService;
import by.gomel.noyvik.library.service.provider.ProviderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;

public class SetAttribute {


    private static final ProviderService PROVIDER_SERVICE = ProviderService.getInstance();

    private SetAttribute(){}

    public static void setAttribute(String target, HttpServletRequest request){

        String resp = request.getParameter("resp");
        request.setAttribute("resp", resp);

        if (target.equalsIgnoreCase(MAIN_JSP)){

            BookService bookService = PROVIDER_SERVICE.getBookService();
            List<Book> books = bookService.findAll();
            request.setAttribute(BOOKS, books);
        } else

        if (target.equalsIgnoreCase(PROFILE_JSP)) {

            OrderService orderService = PROVIDER_SERVICE.getOrderService();
            User user = (User) request.getSession().getAttribute(USER);
            Long userId = user.getId();
            List<Order> orders = orderService.findByUserId(userId);
            request.setAttribute(ORDERS, orders);

        } else

        if (target.equalsIgnoreCase(BOOK_JSP)) {

            BookService bookService = PROVIDER_SERVICE.getBookService();
            OrderService orderService = PROVIDER_SERVICE.getOrderService();

            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookService.findById(bookId);
            request.setAttribute(BOOK, book);

            List<Order> orders = orderService.findByBookId(bookId);
            request.setAttribute(ORDERS, orders);

            User user = (User) request.getSession().getAttribute(USER);

            if (user != null){
                boolean haveBook = orderService.userHaveBook(bookId, user.getId());
                request.setAttribute(HAVE_BOOK, haveBook);
            }


        } else

        if (target.equalsIgnoreCase(BOOK_CONTENT_JSP)) {

            BookService bookService = PROVIDER_SERVICE.getBookService();
            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookService.findById(bookId);
            request.setAttribute(BOOK, book);

        }else
//
//        if (target.equalsIgnoreCase(EDIT_BOOK_JSP)) {
//
//            BookJdbcDao bookDao = BookJdbcDao.getInstance();
//            long bookId = Long.parseLong(request.getParameter("bookId"));
//            Book book = bookDao.findById(bookId);
//            request.setAttribute(BOOK, book);
//            GenreJdbcDao genreDao = GenreJdbcDao.getInstance();
//            List<Genre> genres = genreDao.findAll();
//            request.setAttribute(GENRES, genres);
//            AuthorJdbcDao authorDao = AuthorJdbcDao.getInstance();
//            List<Author> authors = authorDao.findAll();
//            request.setAttribute(AUTHORS, authors);
//
//        }
//
//        if (target.equalsIgnoreCase(ADD_BOOK_JSP)) {
//
//            GenreJdbcDao genreDao = GenreJdbcDao.getInstance();
//            List<Genre> genres = genreDao.findAll();
//            request.setAttribute(GENRES, genres);
//            AuthorJdbcDao authorDao = AuthorJdbcDao.getInstance();
//            List<Author> authors = authorDao.findAll();
//            request.setAttribute(AUTHORS, authors);
//
//        }
//
        if (target.equalsIgnoreCase(ADMIN_JSP)) {

            UserService userService = PROVIDER_SERVICE.getUserService();
            OrderService orderService = PROVIDER_SERVICE.getOrderService();
            MessageService messageService = PROVIDER_SERVICE.getMessageService();

            List<Order> orders = orderService.findAllOverdueOrder();
            request.setAttribute(ORDERS, orders);


            Map<User, Integer> userWithCountOverdueOrder = userService.findUserWithCountOverdueOrder();
            request.setAttribute(USERS, userWithCountOverdueOrder);

            List<Message> messages = messageService.findAll();
            request.setAttribute(MESSAGES, messages);

        }
    }
}
