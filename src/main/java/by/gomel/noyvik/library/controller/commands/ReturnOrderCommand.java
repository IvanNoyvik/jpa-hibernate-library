//package by.gomel.noyvik.library.controller.commands;
//
//import by.gomel.noyvik.library.controller.FrontCommand;
//import by.gomel.noyvik.library.persistance.dao.OrderJdbcDao;
//
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;
//
//public class ReturnOrderCommand extends FrontCommand {
//
//    private static final OrderJdbcDao ORDER_DAO = OrderJdbcDao.getInstance();
//
//
//    @Override
//    public void process() throws ServletException, IOException {
//
//        try {
//            long id = Long.parseLong(request.getParameter(ID));
//            ORDER_DAO.deleteById(id);
//            redirectWithResp(PROFILE_JSP, RETURN_ORDER_OK);
//
//        } catch (Exception e) {
//
//            redirectWithResp(PROFILE_JSP, RETURN_ORDER_FAIL);
//        }
//    }
//}
