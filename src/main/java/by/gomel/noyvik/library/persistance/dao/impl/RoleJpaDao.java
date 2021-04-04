package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.model.Role;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.dao.RoleDao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class RoleJpaDao extends AbstractJpaCrudDao<Role> implements RoleDao {

    private final String ADMIN = "Administrator";
    private final String USER = "User";

    @Override
    public Role getAdminRole() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Role role = (Role) entityManager.createQuery("SELECT r from Role r join fetch r.users where r.role = :role")
                .setParameter("role", ADMIN).getSingleResult();
        entityManager.close();
        return role;
    }

    @Override
    public Role getUserRole() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Role role = (Role) entityManager.createQuery("SELECT r from Role r join fetch r.users where r.role = :role")
                .setParameter("role", USER).getSingleResult();
        entityManager.close();
        return role;
    }
}
