package by.gomel.noyvik.library.persistance.dao;

import by.gomel.noyvik.library.model.User;

public interface UserDao extends CrudDao<User> {

    User findByLoginAndPasswordSqlQuery(String login, String password);

    User findByLoginSqlQuery(String login);

}
