package by.gomel.noyvik.library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Setter
@Getter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateSent;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    public void addUser(User user) {
        user.getMessages().add(this);
        this.setUser(user);
    }

    public void removeUser() {
        user.getMessages().remove(this);
        this.setUser(null);
    }




}
