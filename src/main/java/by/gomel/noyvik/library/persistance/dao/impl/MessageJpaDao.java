package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.model.Message;
import by.gomel.noyvik.library.persistance.dao.MessageDao;

import javax.persistence.EntityManager;
import java.util.List;


public class MessageJpaDao extends AbstractJpaCrudDao<Message> implements MessageDao {

    @Override
    public List<Message> findAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Message> messages = entityManager.createQuery("SELECT m from Message m left join fetch m.user u " +
                "left join fetch u.authenticate", Message.class).getResultList();

        entityManager.close();

        return messages;
    }

    @Override
    public Message save(Message message) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();
        entityManager.close();

        return message;
    }

}
