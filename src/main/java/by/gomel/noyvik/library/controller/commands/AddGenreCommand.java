package by.gomel.noyvik.library.controller.commands;

import by.gomel.noyvik.library.controller.FrontCommand;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.persistance.dao.bookimpl.GenreJdbcDao;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;

public class AddGenreCommand extends FrontCommand {

    private static final GenreJdbcDao GENRE_DAO = GenreJdbcDao.getInstance();


    @Override
    public void process() throws ServletException, IOException {


        String genre = request.getParameter(GENRE);

        if (genre != null && GENRE_DAO.findByGenre(genre) == null) {

            GENRE_DAO.save(new Genre(genre));

            redirectWithResp(ADMIN_JSP, ADD_GENRE_OK);

        } else {

            redirectWithResp(ADMIN_JSP, ADD_GENRE_FAIL);


        }


    }
}
