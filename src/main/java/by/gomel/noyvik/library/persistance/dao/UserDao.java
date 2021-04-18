package by.gomel.noyvik.library.persistance.dao;

import by.gomel.noyvik.library.model.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {


    List<Object[]> findAllWithOrder();

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

}
