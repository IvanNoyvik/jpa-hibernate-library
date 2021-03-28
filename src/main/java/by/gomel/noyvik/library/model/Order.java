package by.gomel.noyvik.library.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(exclude = {"book", "user"})
@ToString(exclude = {"book", "user"})
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;


    public Order(LocalDate date, int duration, Book book, User user) {
        this.date = date;
        this.duration = duration;
        this.book = book;
        this.user = user;
    }


    public void addUser(User user) {
        this.setUser(user);
        user.getOrders().add(this);
    }

    public void removeUser() {
        user.getOrders().remove(this);
        this.setUser(null);
    }

    public void addBook(Book book) {
        this.setBook(book);
        book.getOrders().add(this);
    }

    public void removeBook() {
        book.getOrders().remove(this);
        this.setBook(null);
    }



}
