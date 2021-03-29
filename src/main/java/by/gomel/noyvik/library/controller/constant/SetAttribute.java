package by.gomel.noyvik.library.controller.constant;



import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.impl.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
import static by.gomel.noyvik.library.controller.constant.CommandConstant.MESSAGES;

public interface SetAttribute {

    default void setAttribute(String target, HttpServletRequest request){

        String resp = request.getParameter("resp");
        request.setAttribute("resp", resp);

        if (target.equalsIgnoreCase(MAIN_JSP)){

            BookService bookService = new BookServiceImpl();
            List<Book> books = bookService.findAll();
            request.setAttribute(BOOKS, books);
        }
//
//        if (target.equalsIgnoreCase(PROFILE_JSP)) {
//
//            OrderJdbcDao orderDao = OrderJdbcDao.getInstance();
//            User user = (User) request.getSession().getAttribute(USER);
//            long userId = user.getId();
//            List<Order> orders = orderDao.findByUserId(userId);
//            request.setAttribute(ORDERS, orders);
//
//        }
//
//        if (target.equalsIgnoreCase(BOOK_JSP)) {
//
//            BookJdbcDao bookDao = BookJdbcDao.getInstance();
//            long bookId = Long.parseLong(request.getParameter("bookId"));
//            Book book = bookDao.findById(bookId);
//            request.setAttribute(BOOK, book);
//
//            OrderJdbcDao orderDao = OrderJdbcDao.getInstance();
//            List<Order> orders = orderDao.findByBookId(bookId);
//            request.setAttribute(ORDERS, orders);
//
//            User user = (User) request.getSession().getAttribute(USER);
//
//            if (user != null){
//                boolean haveBook = orderDao.findByBookAndUserId(bookId, user.getId());
//                request.setAttribute(HAVE_BOOK, haveBook);
//            }
//
//
//        }
//
//        if (target.equalsIgnoreCase(BOOK_CONTENT_JSP)) {
//
//            BookJdbcDao bookDao = BookJdbcDao.getInstance();
//            long bookId = Long.parseLong(request.getParameter("bookId"));
//            Book book = bookDao.findById(bookId);
//            request.setAttribute(BOOK, book);
//
//        }
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
//        if (target.equalsIgnoreCase(ADMIN_JSP)) {
//
//            OrderJdbcDao orderDao = OrderJdbcDao.getInstance();
//            List<Order> orders = orderDao.findAllOverdueOrder();
//            request.setAttribute(ORDERS, orders);
//
//            UserJdbcDao userDao = UserJdbcDao.getInstance();
//            List<User> users = userDao.findAll();
//            Map<User, Integer> userWithCountOverdueOrder= new HashMap<>();
//            for (User user: users) {
//                int countOverdueOrder = orderDao.findNumberOfOverdueOrdersByUserId(user.getId());
//                userWithCountOverdueOrder.put(user, countOverdueOrder);
//            }
//            request.setAttribute(USERS, userWithCountOverdueOrder);
//
//            MessageJdbcDao messageDao = MessageJdbcDao.getInstance();
//            List<Message> messages = messageDao.findAll();
//            request.setAttribute(MESSAGES, messages);
//
//        }
    }
}
