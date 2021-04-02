//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.model.User;
//import by.gomel.noyvik.library.persistance.dao.userimpl.RoleJdbcDao;
//import by.gomel.noyvik.library.persistance.dao.userimpl.UserJdbcDao;
//import by.gomel.noyvik.library.persistance.dao.userimpl.UserStatusJdbcDao;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class RegistrationCommand extends FrontCommand {
//
//    private static final UserJdbcDao USER_DAO = UserJdbcDao.getInstance();
//    private static final RoleJdbcDao ROLE_DAO = RoleJdbcDao.getInstance();
//    private static final UserStatusJdbcDao STATUS_DAO = UserStatusJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        String login = request.getParameter(LOGIN);
//        String password = request.getParameter(PASSWORD);
//        String name = request.getParameter(NAME);
//
//        User user = USER_DAO.findByLoginSqlQuery(login);
//
//        if (user == null && !login.isEmpty() && !password.isEmpty()) {
//            user = USER_DAO.save(new User(login, password, name,
//                    STATUS_DAO.getOkStatus(), ROLE_DAO.getUserStatus()));
//            redirectWithResp(MAIN_JSP, REGISTRATION_OK);
//
//        } else {
//
//            redirectWithResp(REGISTRATION_JSP, REGISTRATION_FAIL);
//        }
//
//    }
//}
