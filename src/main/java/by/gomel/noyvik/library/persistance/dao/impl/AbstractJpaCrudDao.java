package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;
import by.gomel.noyvik.library.persistance.connection.ProviderDao;
import by.gomel.noyvik.library.persistance.dao.CrudDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractJpaCrudDao<T> implements CrudDao<T> {

    protected  final EntityManagerFactory entityManagerFactory = JpaEntityManagerFactoryUtil.getEntityManagerFactory();

    protected final ProviderDao providerDao = ProviderDao.getInstance();

    public Class getGenericClass() {
        return (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T t = (T) entityManager.find(getGenericClass(), id);
        entityManager.close();
        return t;
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> users = entityManager.createQuery("from " + getGenericClass().getSimpleName(), getGenericClass()).getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public T save(T t) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    @Override
    public T update(T t) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        t = entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    @Override
    public void deleteById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T t = (T) entityManager.find(getGenericClass(), id);
        entityManager.getTransaction().begin();

        entityManager.remove(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}