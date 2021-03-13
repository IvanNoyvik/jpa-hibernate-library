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
@Table(name = "USERS")
public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public NewUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(id, newUser.id) &&
                Objects.equals(name, newUser.name) &&
                Objects.equals(email, newUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
