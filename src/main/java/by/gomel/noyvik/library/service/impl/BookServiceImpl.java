package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.persistance.dao.AuthorDao;
import by.gomel.noyvik.library.persistance.dao.BookDao;
import by.gomel.noyvik.library.persistance.dao.GenreDao;
import by.gomel.noyvik.library.service.BookService;

import java.io.InputStream;

public class BookServiceImpl extends AbstractCrudService<Book> implements BookService {

    private final BookDao bookDao = PROVIDER_DAO.getBookDao();
    private final GenreDao genreDao = PROVIDER_DAO.getGenreDao();
    private final AuthorDao authorDao = PROVIDER_DAO.getAuthorDao();


    @Override
    public byte[] findImageById(Long id) {
        return bookDao.findImageById(id);
    }

    @Override
    public void addImage(Long id, InputStream inputStream) {
        bookDao.addImage(id, inputStream);
    }

    @Override
    public boolean findByTitleAndAuthor(String title, String author) {

        return !title.isEmpty() && !author.isEmpty() && bookDao.findByTitleAndAuthor(title, author);
    }

    @Override
    public Book save(String title, String description, int quantity, String[] genreName, String authorName) {

        if (!bookDao.findByTitleAndAuthor(title, authorName)) {

            Book book = new Book(title, description, quantity);
            Author author = authorDao.findByAuthor(authorName);
            book.setAuthor(author);




            return bookDao.save(book, genreName);
//            return bookDao.update(book);
        } else {

            throw new SecurityException();
        }

    }


}
