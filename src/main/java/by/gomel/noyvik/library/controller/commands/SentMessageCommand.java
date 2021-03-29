package by.gomel.novik.library.controller.commands;

import by.gomel.novik.library.controller.FrontCommand;
import by.gomel.novik.library.model.Message;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.dao.userimpl.MessageJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.LocalDate;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class SentMessageCommand extends FrontCommand {

    private static final MessageJdbcDao MESSAGE_DAO = MessageJdbcDao.getInstance();


    @Override
    public void process() throws ServletException, IOException {

        String context = request.getParameter(CONTEXT);
        User user = (User) request.getSession().getAttribute(USER);
        try {

            Message message = new Message(LocalDate.now(), context, user);
            MESSAGE_DAO.save(message);
            redirectWithResp(BLOCK_JSP, SENT_MESSAGE_OK);

        } catch (Exception e) {

            redirectWithResp(BLOCK_JSP, SENT_MESSAGE_FAIL);


        }


    }
}
