package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.model.Status;
import by.gomel.noyvik.library.persistance.dao.MessageDao;
import by.gomel.noyvik.library.persistance.dao.StatusDao;


public class StatusJpaDao extends AbstractJpaCrudDao<Status> implements StatusDao {


    @Override
    public Status getOkStatus() {
        return null;
    }

    @Override
    public Status getLimitedStatus() {
        return null;
    }

    @Override
    public Status getLockedStatus() {
        return null;
    }
}
