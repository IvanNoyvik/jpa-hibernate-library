package by.gomel.noyvik.library.controller.commands;

import by.gomel.library.exception.DaoPartException;
import by.gomel.noyvik.library.controller.FrontCommand;
import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.persistance.dao.bookimpl.AuthorJdbcDao;
import by.gomel.noyvik.library.persistance.dao.bookimpl.BookJdbcDao;
import by.gomel.noyvik.library.persistance.dao.bookimpl.GenreJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.novik.library.controller.constant.CommandConstant.*;

public class AddBookCommand extends FrontCommand {

    private static final BookJdbcDao BOOK_DAO = BookJdbcDao.getInstance();
    private static final GenreJdbcDao GENRE_DAO = GenreJdbcDao.getInstance();
    private static final AuthorJdbcDao AUTHOR_DAO = AuthorJdbcDao.getInstance();


    @Override
    public void process() throws ServletException, IOException {

        String title = request.getParameter(TITLE);
        String description = request.getParameter(DESCRIPTION);
        int quantity;

        try {
            quantity = Integer.parseInt(request.getParameter(QUANTITY));

        } catch (NumberFormatException e) {

            redirectWithResp(MAIN_JSP, PARSE_NUMBER_EXCEPTION);
            return;
        }

        long genreId = Long.parseLong(request.getParameter(GENRE));
        Genre genre = GENRE_DAO.findById(genreId);

        long authorId = Long.parseLong(request.getParameter(AUTHOR));
        Author author = AUTHOR_DAO.findById(authorId);

        if (!BOOK_DAO.findByTitleAndAuthor(title, author.getAuthor())) {


            Book book = new Book();
            book.setTitle(title);
            book.setDescription(description);
            book.setQuantity(quantity);
            book.setGenre(genre);
            book.setAuthor(author);

            try {

                book = BOOK_DAO.save(book);

                redirectWithResp(MAIN_JSP, ADD_BOOK_OK);

            } catch (DaoPartException e) {

                redirectWithResp(MAIN_JSP, ADD_BOOK_FAIL);

            }

        } else {

            redirectWithResp(MAIN_JSP, ADD_BOOK_FAIL);

        }

    }
}
