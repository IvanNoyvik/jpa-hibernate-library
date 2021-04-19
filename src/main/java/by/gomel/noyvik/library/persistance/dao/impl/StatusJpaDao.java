package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Status;
import by.gomel.noyvik.library.persistance.dao.StatusDao;

import javax.persistence.EntityManager;


public class StatusJpaDao extends AbstractJpaCrudDao<Status> implements StatusDao {


    private final String OK = "OK";
    private final String LOCKED = "Locked";
    private final String LIMITED = "Limited";


    @Override
    public Status getStatus(String statusStr) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Status status = entityManager.createQuery(
                "SELECT s from Status s join fetch s.users where s.status = :status", Status.class)
                .setParameter("status", statusStr).getSingleResult();
        entityManager.close();
        return status;
    }

    @Override
    public Status getOkStatus() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Status status = (Status) entityManager.createQuery("SELECT s from Status s join fetch s.users where s.status = :status")
                .setParameter("status", OK).getSingleResult();
        entityManager.close();
        return status;
    }

    @Override
    public Status getLockedStatus() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Status status = (Status) entityManager.createQuery("SELECT s from Status s join fetch s.users where s.status = :status")
                .setParameter("status", LOCKED).getSingleResult();
        entityManager.close();
        return status;
    }

    @Override
    public Status getLimitedStatus() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Status status = (Status) entityManager.createQuery("SELECT s from Status s join fetch s.users where s.status = :status")
                .setParameter("status", LIMITED).getSingleResult();
        entityManager.close();
        return status;
    }
}
