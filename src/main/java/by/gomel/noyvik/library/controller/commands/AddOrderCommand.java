//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.model.Book;
//import by.gomel.noyvik.library.model.Order;
//import by.gomel.noyvik.library.model.User;
//import by.gomel.noyvik.library.persistance.dao.OrderJdbcDao;
//import by.gomel.noyvik.library.persistance.dao.bookimpl.BookJdbcDao;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//import java.time.LocalDate;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class AddOrderCommand extends FrontCommand {
//
//    private static final OrderJdbcDao ORDER_DAO = OrderJdbcDao.getInstance();
//    private static final BookJdbcDao BOOK_DAO = BookJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
//        User user = (User) request.getSession().getAttribute(USER);
//        Book book = BOOK_DAO.findById(bookId);
//        long userId = user.getId();
//        int duration;
//
//        try {
//            duration = Integer.parseInt(request.getParameter(DAYS));
//
//        } catch (NumberFormatException e) {
//
//            redirectWithResp(MAIN_JSP, PARSE_NUMBER_EXCEPTION);
//            return;
//        }
//
//
//        if (user.getStatus().getStatus().equalsIgnoreCase("OK")
//                && !ORDER_DAO.findByBookAndUserId(bookId, userId)
//                && book.getQuantity() > 0
//                && duration <= 180) {
//
//
//            Order order = new Order(LocalDate.now(), duration, book, user);
//
//            ORDER_DAO.save(order);
//
//            redirectWithResp(PROFILE_JSP, ADD_ORDER_OK);
//
//        } else {
//
//            redirectWithResp(MAIN_JSP, ADD_ORDER_FAIL);
//
//        }
//
//
//    }
//}
