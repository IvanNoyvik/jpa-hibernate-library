//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.persistance.dao.bookimpl.BookJdbcDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import java.io.IOException;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class GetImageCommand extends FrontCommand {
//
//    private static final BookJdbcDao BOOK_DAO = BookJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        long bookId = Long.parseLong(request.getParameter(BOOK_ID));
//        byte[] image = BOOK_DAO.findImageById(bookId);
//
//
//        if (image != null) {
//
//            try (ServletOutputStream outputStream = response.getOutputStream()) {
//                outputStream.write(image);
//            }
//
//        } else {
//
//            response.sendRedirect(request.getContextPath() + NO_IMAGE);
//        }
//
//
//    }
//}
