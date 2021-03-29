//package by.gomel.noyvik.library.persistance.dao.user;
//
//
//import by.gomel.noyvik.library.persistance.dao.AbstractCrudDao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import java.util.List;
//import java.util.Optional;
//
//public class NewUserDaoJpaImpl extends AbstractCrudDao<NewUser> {
//
//    @Override
//    public List<NewUser> findAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<NewUser> users = entityManager.createQuery("from NewUser", NewUser.class).getResultList();
//        entityManager.close();
//        return users;
//    }
//
//    public List<NewUser> findAllWithAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        List<NewUser> users = entityManager.createQuery("from NewUser", NewUser.class).getResultList();
//        entityManager.close();
//        return users;
//    }
//
//    @Override
//    public NewUser findById(long id) {
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        NewUser user =  entityManager.createQuery("select u from NewUser u where u.id = ?1", NewUser.class).setParameter(1, id).getSingleResult();
//        entityManager.close();
//        return user;
//    }
//
//    @Override
//    public NewUser save(NewUser newUser) {
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createNativeQuery("INSERT INTO USERS (NAME, EMAIL) VALUES (?1, ?2)")
//                .setParameter(1, newUser.getName()).setParameter(2, newUser.getEmail())
//                .executeUpdate();
//        NewUser user = entityManager.createQuery("from NewUser order by id desc", NewUser.class).setMaxResults(1).getSingleResult();
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//        return user;
//    }
//
//    @Override
//    public NewUser update(NewUser user) {
//        EntityManager entityManager = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            entityManager.getTransaction().begin();
//
//            entityManager.createQuery("update NewUser set NAME = :userName, email = :email where id = :id")
//                    .setParameter("userName", user.getName())
//                    .setParameter("email", user.getEmail())
//                    .setParameter("id", user.getId())
//                    .executeUpdate();
//
//            entityManager.getTransaction().commit();
//
//        } catch (Exception e) {
//            Optional.ofNullable(entityManager).map(EntityManager::getTransaction)
//                    .ifPresent(EntityTransaction::rollback);
//
//            e.printStackTrace();
//            System.err.println("Error process update method for User - " + e.getMessage());
//        } finally {
//            if (entityManager != null && entityManager.isOpen()) {
//                entityManager.close();
//            }
//        }
//        return user;
//    }
//
//    @Override
//    public void deleteById(long id) {
//
//        EntityManager entityManager = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            entityManager.getTransaction().begin();
//            entityManager.createQuery("delete from NewUser where id = :id").setParameter("id", id).executeUpdate();
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            Optional.ofNullable(entityManager).map(EntityManager::getTransaction)
//                    .ifPresent(EntityTransaction::rollback);
//
//            e.printStackTrace();
//            System.err.println("Error process delete method for User - " + e.getMessage());
//        } finally {
//            if (entityManager != null && entityManager.isOpen()) {
//                entityManager.close();
//            }
//        }
//    }
//}
