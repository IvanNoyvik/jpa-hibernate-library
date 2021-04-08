package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "booksDto")
@ToString(exclude = "booksDto")
@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String author;

    private Set<BookDto> booksDto = new HashSet<>();


    public AuthorDto(String author) {
        this.author = author;
    }

    public void addBook(BookDto bookDto) {
        booksDto.add(bookDto);
        bookDto.setAuthorDto(this);
    }

    public void removeUser(BookDto bookDto) {
        booksDto.remove(bookDto);
        bookDto.setAuthorDto(null);
    }
}
