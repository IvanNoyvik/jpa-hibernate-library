package by.gomel.noyvik.library.service.impl;

import by.gomel.noyvik.library.model.Author;
import by.gomel.noyvik.library.model.Book;
import by.gomel.noyvik.library.model.Genre;
import by.gomel.noyvik.library.persistance.connection.ProviderDao;
import by.gomel.noyvik.library.service.BookService;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BookServiceImpl extends AbstractCrudService<Book> implements BookService {


    @Override
    public byte[] findImageById(Long id) {
       return PROVIDER_DAO.getBookDao().findImageById(id);
    }

    @Override
    public void addImage(Long id, InputStream inputStream) {
        PROVIDER_DAO.getBookDao().addImage(id,inputStream);
    }

    @Override
    public boolean findByTitleAndAuthor(String title, String author) {

        return !title.isEmpty() && !author.isEmpty() && PROVIDER_DAO.getBookDao().findByTitleAndAuthor(title, author);
    }

    @Override
    public Book save(String title, String description, int quantity, String genreName, String authorName) {

        if (quantity <= 180 && quantity >= 0){

            Genre genre = PROVIDER_DAO.getGenreDao().findByGenre(genreName);
            Author author = PROVIDER_DAO.getAuthorDao().findByAuthor(authorName);

            return super.save(Book.builder()
                    .title(title).description(description).quantity(quantity)
                    .genres(new HashSet<>(Collections.singletonList(genre))).author(author).build());

        } else {

            throw new SecurityException();
        }

    }


}
