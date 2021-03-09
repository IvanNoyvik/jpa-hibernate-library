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
public class Authenticate {

    @Id
    private Long id;
    private String login;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Authenticate(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void addUser(User user) {
        this.user = user;
        user.setAuthenticate(this);
    }

    public void removeUser() {
        this.user = null;
        user.setAuthenticate(null);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authenticate that = (Authenticate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return "Authenticate{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
