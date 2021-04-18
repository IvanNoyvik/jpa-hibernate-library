package by.gomel.noyvik.library;

import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;
import org.h2.tools.Server;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class Runner {

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

        String a1 = null;

        String a2 = "";
        String a3 = " ";

        System.out.println(a2.isEmpty());
        System.out.println(a3.isEmpty());

        System.out.println(a1.isEmpty());

    }
}
