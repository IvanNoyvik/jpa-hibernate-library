package by.gomel.noyvik.library.model.dto;


import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(exclude = {"bookDto", "userDto"})
@ToString(exclude = {"bookDto", "userDto"})
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long id;
    private LocalDate dateReceiving;
    private int duration;

    private BookDto bookDto;

    private UserDto userDto;


    public OrderDto(LocalDate dateReceiving, int duration, BookDto bookDto, UserDto userDto) {
        this.dateReceiving = dateReceiving;
        this.duration = duration;
        this.bookDto = bookDto;
        this.userDto = userDto;
    }


    public void addUser(UserDto userDto) {
        this.setUserDto(userDto);
        userDto.getOrdersDto().add(this);
    }

    public void removeUser() {
        userDto.getOrdersDto().remove(this);
        this.setUserDto(null);
    }

    public void addBook(BookDto bookDto) {
        this.setBookDto(bookDto);
        bookDto.getOrdersDto().add(this);
    }

    public void removeBook() {
        bookDto.getOrdersDto().remove(this);
        this.setBookDto(null);
    }



}
