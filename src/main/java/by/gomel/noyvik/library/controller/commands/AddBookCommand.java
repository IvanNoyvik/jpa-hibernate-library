package by.gomel.noyvik.library.controller.commands;

import by.gomel.noyvik.library.controller.FrontCommand;
import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Genre;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.gomel.noyvik.library.controller.constant.CommandConstant.*;

public class AddBookCommand extends FrontCommand {




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

        String genres = request.getParameter(GENRE);
        String author = request.getParameter(AUTHOR);

        if (!PROVIDER_SERVICE.getBookService().findByTitleAndAuthor(title, author)) {



            try {

                Book book = PROVIDER_SERVICE.getBookService().save(title, description, quantity, genres, author);

                redirectWithResp(MAIN_JSP, ADD_BOOK_OK);

            } catch (SecurityException e) {

                redirectWithResp(MAIN_JSP, ADD_BOOK_FAIL);

            }

        } else {

            redirectWithResp(MAIN_JSP, ADD_BOOK_FAIL);

        }

    }
}
