package by.gomel.noyvik.library;

import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.NewUser;
import by.gomel.noyvik.library.model.Role;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;
import by.gomel.noyvik.library.persistance.dao.user.UserDaoJpaImpl;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

public class Runner2 {

    private static Server SERVER;

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
//        NewUserDaoJpaImpl newUserDaoJpa = new NewUserDaoJpaImpl();

    }
}
