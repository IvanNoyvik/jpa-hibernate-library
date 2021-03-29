package by.gomel.noyvik.library;

import by.gomel.noyvik.library.model.Authenticate;
import by.gomel.noyvik.library.model.Role;
import by.gomel.noyvik.library.model.User;
import by.gomel.noyvik.library.persistance.connection.JpaEntityManagerFactoryUtil;
import by.gomel.noyvik.library.persistance.dao.impl.UserDaoJsqlJpaImpl;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

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

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        UserDaoJsqlJpaImpl userDaoJpa = new UserDaoJsqlJpaImpl();


        User iAm = new User("Новик Иван", "noyvikivan@mail.ru");
        User algerd = new User("Нестерков Альгерд", "mohnatishmel@gmail.com");
        User andrei = new User("Дмитриев Андрей", "maksinn.bondarev.discord24@bk.ru");
        User aleksei = new User("Какора Алексей", "akakora@yandex.by");
        User maxim = new User("Маевский Максим", "kantasenadas@gmail.com");
        User sergei = new User("Маевский Сергей", "rostprominvest@mail.ru");



        iAm.addAuthenticate(new Authenticate("ivan", "1"));
        iAm.addRole(new Role("ADMIN"));
        iAm.addRole(new Role("TESTER"));
        iAm.addRole(new Role("USER"));
        iAm.addRole(new Role("MANAGER"));

        algerd.addAuthenticate(new Authenticate("algerd", "1"));
        algerd.addRole(new Role("USER"));
        algerd.addRole(new Role("MANAGER"));

        andrei.addAuthenticate(new Authenticate("andrei", "1"));
        andrei.addRole(new Role("TESTER"));
        andrei.addRole(new Role("USER"));

        aleksei.addAuthenticate(new Authenticate("aleksei", "1"));
        aleksei.addRole(new Role("ADMIN"));
        aleksei.addRole(new Role("USER"));
        aleksei.addRole(new Role("MANAGER"));

        maxim.addAuthenticate(new Authenticate("maxim", "1"));
        maxim.addRole(new Role("USER"));

        sergei.addAuthenticate(new Authenticate("sergei", "1"));
        sergei.addRole(new Role("USER"));
        sergei.addRole(new Role("MANAGER"));

        userDaoJpa.save(iAm);
        userDaoJpa.save(algerd);
        userDaoJpa.save(andrei);
        userDaoJpa.save(aleksei);
        userDaoJpa.save(maxim);
        userDaoJpa.save(sergei);

        List<User> users = userDaoJpa.findAll();

        users.forEach(user -> user.getRoles().forEach(System.out::println));

       users.stream().filter(user -> user.getRoles().contains(new Role("TESTER"))).forEach(user -> userDaoJpa.deleteById(user.getId()));

        users = userDaoJpa.findAll();

        users.forEach(System.out::println);

        System.out.println();

        users.forEach(user -> user.getRoles().forEach(System.out::println));


//        System.out.printf("%d - %s, %s, %s", user);


    }
}
