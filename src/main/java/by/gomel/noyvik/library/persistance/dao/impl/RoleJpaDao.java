package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.model.Role;
import by.gomel.noyvik.library.persistance.dao.MessageDao;
import by.gomel.noyvik.library.persistance.dao.RoleDao;


public class RoleJpaDao extends AbstractJpaCrudDao<Role> implements RoleDao {


    @Override
    public Role getAdminRole() {
        return null;
    }

    @Override
    public Role getUserRole() {
        return null;
    }
}
