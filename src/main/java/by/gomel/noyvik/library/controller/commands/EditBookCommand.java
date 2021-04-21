//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.exception.DaoPartException;
//import by.gomel.noyvik.library.model.Author;
//import by.gomel.noyvik.library.model.Book;
//import by.gomel.noyvik.library.model.Genre;
//import by.gomel.noyvik.library.service.BookService;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class EditBookCommand extends FrontCommand {
//
//    private  final BookService bookService = PROVIDER_SERVICE.getBookService();
//    private static final GenreJdbcDao GENRE_DAO = GenreJdbcDao.getInstance();
//    private static final AuthorJdbcDao AUTHOR_DAO = AuthorJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
//
//        String title = request.getParameter(TITLE);
//        String description = request.getParameter(DESCRIPTION);
//
//        int quantity;
//        try {
//            quantity = Integer.parseInt(request.getParameter(QUANTITY));
//
//        } catch (NumberFormatException e) {
//
//            redirectWithResp(MAIN_JSP, PARSE_NUMBER_EXCEPTION);
//            return;
//        }
//
//        String[] genres = request.getParameterValues(GENRES);
//        long authorId = Long.parseLong(request.getParameter(AUTHOR));
//
//        if
//        try {
//
//            book = BOOK_DAO.update(book);
//
//            redirectWithResp(MAIN_JSP, EDIT_BOOK_OK);
//
//        } catch (DaoPartException e) {
//
//            redirectWithResp(MAIN_JSP, EDIT_BOOK_FAIL);
//
//        }
//    }
//}
