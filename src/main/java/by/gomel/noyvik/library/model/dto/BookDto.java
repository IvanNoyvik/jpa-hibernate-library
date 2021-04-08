package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authorDto", "genresDto", "ordersDto"})
@ToString(exclude = {"authorDto", "genresDto", "ordersDto"})
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String description;
    private byte[] image;
    private int quantity;

    private AuthorDto authorDto;

    private Set<GenreDto> genresDto;

    private Set<OrderDto> ordersDto;


    public BookDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public BookDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addOrder(OrderDto orderDto) {
        ordersDto.add(orderDto);
        orderDto.setBookDto(this);
    }

    public void removeOrder(OrderDto orderDto) {
        ordersDto.remove(orderDto);
        orderDto.setBookDto(null);
    }

    public void addAuthor(AuthorDto authorDto) {
        this.setAuthorDto(authorDto);
        authorDto.getBooksDto().add(this);
    }

    public void removeAuthor() {
        authorDto.getBooksDto().remove(this);
        this.setAuthorDto(null);
    }

    public void addGenre(GenreDto genreDto) {
        genresDto.add(genreDto);
        genreDto.getBooksDto().add(this);
    }

    public void removeGenre(GenreDto genreDto) {
        genresDto.remove(genreDto);
        genreDto.getBooksDto().remove(this);
    }
}
