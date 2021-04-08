package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.exception.ServiceException;
import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Status;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.StatusDao;
import by.gomel.noyvik.library.persistance.dao.UserDao;
import by.gomel.noyvik.library.service.UserService;

import java.time.LocalDate;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;

public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private final UserDao userDao = PROVIDER_DAO.getUserDao();
    private final StatusDao statusDao = PROVIDER_DAO.getStatusDao();


    @Override
    public User findByLoginAndPassword(String login, String password) {

        User user;

        try {
            user = userDao.findByLoginAndPassword(login, password);
        } catch (DaoPartException e) {

            throw new ServiceException(e);
        }

        if (user != null) {

            if (user.getStatus().getStatus().equalsIgnoreCase(LIMITED) && user.getAuthenticate().getUnlockedDate().isBefore(LocalDate.now())) {

                user.addStatus(statusDao.getOkStatus());
                userDao.update(user);

            }
        }
        return user;
    }

    @Override
    public boolean isExists(String login) {
        User user;
        try {

            user = userDao.findByLogin(login);
        } catch (DaoPartException e) {
            throw new ServiceException(e);
        }
        return user != null;
    }

    @Override
    public User registration(String login, String password, String name, String email) {

        if (!isExists(login)) {

            try {

                Authenticate authenticate = new Authenticate(login, password);
                User user = new User(name, email);
                user.addAuthenticate(authenticate);

                Status status = statusDao.getOkStatus();
                user.addStatus(status);

                return userDao.save(user);

            } catch (Exception e) {
                throw new ServiceException(e);
            }

        }

        return null;

    }
}
