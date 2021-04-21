package by.gomel.noyvik.library.persistance.dao.impl;


import by.gomel.noyvik.library.exception.DaoPartException;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.persistance.dao.BookDao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;


public class BookJpaDao extends AbstractJpaCrudDao<Book> implements BookDao {


    @Override
    public Book findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.createQuery(
                "SELECT b from Book b left join fetch b.author left join fetch b.genres where b.id = :id", Book.class)
                .setParameter("id", id).getSingleResult();
        entityManager.close();
        return book;
    }

    @Override
    public List<Book> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Book> books = entityManager.createQuery("SELECT b from Book b left join fetch b.author", Book.class)
                .getResultList();
        entityManager.close();
        return books;
    }

    @Override
    public byte[] findImageById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        byte[] image = book.getImage();
        entityManager.close();
        return image;
    }

    @Override
    public void addImage(Long id, byte[] image) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Book book = entityManager.find(Book.class, id);
            book.setImage(image);
            entityManager.merge(book);
            entityManager.getTransaction().commit();
        }catch ( Exception e){
            throw new DaoPartException("Add image method fail!", e);
        } finally {

            entityManager.close();
        }

    }

    @Override
    public boolean findByTitleAndAuthor(String title, String author) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.createQuery("from Book where title = :title and author.author = :author")
                    .setParameter("title", title).setParameter("author", author).getSingleResult();
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            throw new DaoPartException(e.getMessage(), e);
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Book save(Book book, String[] genreName) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{

            entityManager.getTransaction().begin();
            if (genreName.length > 1) {
                List<Genre> genreList = entityManager.createQuery(
                        "select distinct g from Genre g left join fetch g.books", Genre.class).getResultList();
                for (Genre genre : genreList) {
                    for (String genreStr : genreName) {

                        if (genreStr.equals(genre.getGenre())) {
//                            genres.add(genre);
                            book.addGenre(genre);
                            break;
                        }
                    }
                }

            } else {

                Genre genre = entityManager.createQuery("from Genre g left join fetch g.books where g.genre = :genre", Genre.class)
                        .setParameter("genre", genreName[0]).getSingleResult();
                book.addGenre(genre);
            }

            entityManager.persist(book);
            entityManager.getTransaction().commit();
        }catch ( Exception e){
            throw new DaoPartException();
        } finally {

            entityManager.close();
        }

        return book;
    }
}
