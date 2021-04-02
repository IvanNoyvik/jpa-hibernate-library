//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.model.Order;
//import by.gomel.noyvik.library.model.User;
//import by.gomel.noyvik.library.model.UserStatus;
//import by.gomel.noyvik.library.persistance.dao.OrderJdbcDao;
//import by.gomel.noyvik.library.persistance.dao.userimpl.UserJdbcDao;
//import by.gomel.noyvik.library.persistance.dao.userimpl.UserStatusJdbcDao;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//import java.util.List;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class ChangeStatusCommand extends FrontCommand {
//
//    private static final UserJdbcDao USER_DAO = UserJdbcDao.getInstance();
//    private static final UserStatusJdbcDao STATUS_DAO = UserStatusJdbcDao.getInstance();
//    private static final OrderJdbcDao ORDER_DAO = OrderJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        try {
//            long userId = Long.parseLong(request.getParameter(USER_ID));
//            String status = request.getParameter(STATUS);
//
//            User user = USER_DAO.findById(userId);
//
//            if (status.equalsIgnoreCase(OK)) {
//
//                user.setStatus(STATUS_DAO.getOkStatus());
//
//            } else if (status.equalsIgnoreCase(LOCKED)) {
//
//                user.setStatus(STATUS_DAO.getLockedStatus());
//                List<Order> orders = ORDER_DAO.findByUserId(userId);
//                orders.forEach(order -> ORDER_DAO.deleteById(order.getId()));
//
//
//            } else if (status.equalsIgnoreCase(LIMITED)) {
//
//                int duration = Integer.parseInt(request.getParameter(DURATION));
//                UserStatus newStatus = STATUS_DAO.save(new UserStatus(LIMITED, duration));
//                user.setStatus(newStatus);
//
//            }
//
//
//            USER_DAO.update(user);
//
//            redirectWithResp(ADMIN_JSP, CHANGE_STATUS_OK);
//
//        } catch (Exception e) {
//
//            redirectWithResp(ADMIN_JSP, CHANGE_STATUS_FAIL);
//
//        }
//
//
//    }
//}
