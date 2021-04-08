package by.gomel.noyvik.library.model.dto;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "booksDto")
@ToString(exclude = "booksDto")
@Getter
@Setter
public class GenreDto {

    private Long id;
    private String genre;


    private Set<BookDto> booksDto = new HashSet<>();



    public GenreDto(String genre) {
        this.genre = genre;
    }

    public void addBook(BookDto bookDto) {
        booksDto.add(bookDto);
        bookDto.getGenresDto().add(this);
    }

    public void removeBook(BookDto bookDto) {
        booksDto.remove(bookDto);
        bookDto.getGenresDto().remove(this);
    }
}
