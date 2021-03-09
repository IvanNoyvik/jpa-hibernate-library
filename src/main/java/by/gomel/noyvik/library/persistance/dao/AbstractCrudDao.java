package by.gomel.noyvik.library.persistance.dao;


import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractCrudDao<T> {

    protected  final EntityManagerFactory entityManagerFactory = JpaEntityManagerFactoryUtil.getEntityManagerFactory();

    public Class getGenericClass() {
        return (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T t = (T) entityManager.find(getGenericClass(), id);
        entityManager.close();
        return t;
    }

    public List<T> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> users = entityManager.createQuery("from " + getGenericClass().getSimpleName(), getGenericClass()).getResultList();
        entityManager.close();
        return users;
    }

    public T save(T t) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    public T update(T t) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        t = entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    public void deleteById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T t = (T) entityManager.find(getGenericClass(), id);
        entityManager.getTransaction().begin();

        entityManager.remove(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}