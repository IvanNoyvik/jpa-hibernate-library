//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.library.exception.DaoPartException;
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.persistance.dao.userimpl.UserJdbcDao;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class DeleteUserCommand extends FrontCommand {
//
//    private static final UserJdbcDao USER_DAO = UserJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        try {
//            long userId = Long.parseLong(request.getParameter(USER_ID));
//            USER_DAO.deleteById(userId);
//
//            redirectWithResp(ADMIN_JSP, DELETE_USER_OK);
//
//        } catch (DaoPartException e) {
//
//            redirectWithResp(ADMIN_JSP, DELETE_USER_FAIL);
//
//        }
//
//
//    }
//}
