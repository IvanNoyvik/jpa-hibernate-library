package by.gomel.noyvik.library;

import by.gomel.noyvik.library.model.*;
import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;
import by.gomel.noyvik.library.persistance.dao.CrudDao;
import by.gomel.noyvik.library.persistance.dao.RoleDao;
import by.gomel.noyvik.library.persistance.dao.StatusDao;
import by.gomel.noyvik.library.persistance.dao.UserDao;
import by.gomel.noyvik.library.persistance.dao.impl.RoleJpaDao;
import by.gomel.noyvik.library.persistance.dao.impl.StatusJpaDao;
import by.gomel.noyvik.library.persistance.dao.impl.UserDaoJsqlJpaImpl;
import by.gomel.noyvik.library.persistance.dao.impl.UserJpaDao;
import by.gomel.noyvik.library.service.BookService;
import by.gomel.noyvik.library.service.impl.BookServiceImpl;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class Runner2 {

    private static Server SERVER;
    private static UserDao userDao = new UserJpaDao();

    static {
        try {
            SERVER = Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("Failed start tcp H2 server");
        }
    }

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = JpaEntityManagerFactoryUtil.getEntityManagerFactory();

    public static void main(String[] args) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

//        BookService bookService = new BookServiceImpl();
//
//        Book book = bookService.findById(1L);
//        System.out.println(book.getAuthor());
//        System.out.println(book.getOrders());
//        System.out.println(book.getGenres());
//
//        System.out.println(book);


        String login = "12345";

        String password = "asdf";

        Authenticate authenticate = new Authenticate(login, password);
        RoleDao roleDao = new RoleJpaDao();
//        Role role = (Role) entityManager.createQuery("SELECT r from Role r join fetch r.users where r.role = :role")
//                .setParameter("role", "Administrator").getSingleResult();
        StatusDao statusDao = new StatusJpaDao();
//        Status status = (Status) entityManager.createQuery("SELECT s from Status s join fetch s.users where s.status = :status")
//                .setParameter("status", "OK").getSingleResult();
        String name = login;
        String email = login;
        User user = new User(name, email);

        Status status = statusDao.getOkStatus();
        user.addStatus(status);
        Role role = roleDao.getUserRole();
        user.addRole(role);
        user.addAuthenticate(authenticate);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
//        User save = userDao.save(user);

        System.out.println();

    }
}
