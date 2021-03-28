package by.gomel.noyvik.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authenticate", "roles", "orders", "messages", "status"})
@ToString(exclude = {"authenticate", "roles", "orders", "messages", "status"})
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Authenticate authenticate;

    @ManyToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Role> roles = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserStatus status;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public void addAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
        authenticate.setUser(this);
    }

    public void removeAuthenticate() {
        authenticate.setUser(null);
        this.setAuthenticate(null);

    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

    public void addStatus(UserStatus status) {
        this.setStatus(status);
        status.getUsers().add(this);
    }

    public void removeStatus() {
        this.setStatus(null);
        status.getUsers().remove(this);
    }

    public void addMessage(Message message) {
        messages.add(message);
        message.setUser(this);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
        message.setUser(null);
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }

}
