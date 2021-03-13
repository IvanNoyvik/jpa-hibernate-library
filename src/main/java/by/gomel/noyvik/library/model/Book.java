package by.gomel.noyvik.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Book(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addUser(User user) {
        this.user = user;
        user.getBooks().add(this);
    }

    public void removeUser(User user) {
        this.user = null;
        user.getBooks().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
